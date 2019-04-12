package com.zsx.exception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;

import com.zsx.mail.MailSendUtil;

import net.sf.json.JSONObject;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by lenovo on 2015/7/31.
 */
//@Aspect
public class ExceptionAspect {
    /**
     * 捕捉异常
     * @param  @param point
     * @param  @return
     * @param  @throws Throwable    设定文件
     * @return Object    DOM对象
     * @throws
     * @since  　Ver 1.0.0
     */
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = null;
        System.out.println("zhao --- " + point);
        try {
            args = point.getArgs();
            Object o = point.proceed();
            return o;
        }catch (Throwable e) {
            if(e instanceof NoEmailException) {
                //不用发送邮件
                return null;
            }
            String lineBreak = System.getProperty("line.separator");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 时间
            String time = df.format(new Date());
            StringBuilder sb1 = new StringBuilder();
            for (Object arg : args) {
                try {
                    JSONObject json = JSONObject.fromObject(arg);
                    Set<Object> keys = json.entrySet();
                    if (keys.size() == 0) {
                        sb1.append(arg + "  ");
                    }
                    else {
                        for (Object key : keys) {
                            sb1.append(key).append(lineBreak);
                        }
                    }
                }
                catch (Exception ee) {
//                    log.info("JSON转换错误" + ee.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            StackTraceElement[] stackTraces = e.getStackTrace();
            for (StackTraceElement stack : stackTraces) {
                sb2.append(stack.toString()).append(lineBreak);
            }

//            MailSendUtil.sendMail("时间："
//                    + lineBreak + time + lineBreak + "<br></br>参数:" + lineBreak + sb1 + "<br></br>异常:"
//                    + e.toString() + "<br></br>" + sb2);

            System.out.println("赵树学赵树学赵树学赵树学赵树学赵树学赵树学赵树学赵树学赵树学赵树学赵树学");

            throw e;
        }
    }
}
