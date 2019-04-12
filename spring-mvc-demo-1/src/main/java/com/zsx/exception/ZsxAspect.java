package com.zsx.exception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zsx.mail.MailSendUtil;

import net.sf.json.JSONObject;

/**
 * Created by highness on 2017/6/3 0003.
 */

@Component
@Aspect
public class ZsxAspect {

    private final Logger logger = LoggerFactory.getLogger(ZsxAspect.class);

    //    public static final String EDP = "execution(* com.zsx.service.impl.*.*(..))";
//    public static final String EDP = "execution(* com.zsx.*.*(..))";
    public static final String EDP = "execution(* com.*..*.*(..))";

    public ZsxAspect() {
		
	}
    
//    org.slf4j

//	@Pointcut("execution(* com.*.service..*.*(..))")
//	@Pointcut("(execution(* com.*.service..*.*(..))) or (execution(* org.slf4j..*.*(..)))")
	@Pointcut("execution(* org.slf4j..*.*(..))")
    private void pointCutMethod(){
    }
    
    /**
     *  声明前置通知
     */
//    @Before(EDP)
    @Before("pointCutMethod()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("前置通知");
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        logger.debug(className + "的" + methodName + "执行了");
//        System.out.println(className + "的" + methodName + "执行了");
//        Object[] args = joinPoint.getArgs();
//        StringBuilder log = new StringBuilder("入参为");
//        for (Object arg : args) {
//            log.append(arg + " ");
//        }
//        logger.debug(log.toString());
//        System.out.println(log.toString());
    }
    
    
    /**
     *  声明后置通知
     * @param result
     */
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning(String result) {
        System.out.println("后置通知");
        System.out.println("---" + result + "---");
    }

    /**
     *  声明例外通知
     */
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        System.out.println("例外通知");
        System.out.println("例外通知1" + e.toString());
        System.out.println("例外通知2" + e.getMessage());
    }

    /**
     *  声明最终通知
     */
    @After("pointCutMethod()")
    public void doAfter() {
        System.out.println("最终通知");
    }

    /**
     *  声明环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
//    @Around("pointCutMethod()")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("进入方法---环绕通知");
//        Object o = pjp.proceed();
//        System.out.println("退出方法---环绕通知");
//        return o;
//    }

    @Around("pointCutMethod()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = null;
        try {
            args = point.getArgs();
            Object o = point.proceed();

          String className = point.getTarget().getClass().getName();
          String methodName = point.getSignature().getName();
          logger.debug(className + "的" + methodName + "执行了");
          System.out.println(className + "的" + methodName + "执行了");
            
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
//            for (Object arg : args) {
//                try {
//                    JSONObject json = JSONObject.fromObject(arg);
//                    Set<Object> keys = json.entrySet();
//                    if (keys.size() == 0) {
//                        sb1.append(arg + "  ");
//                    }
//                    else {
//                        for (Object key : keys) {
//                            sb1.append(key).append(lineBreak);
//                        }
//                    }
//                }
//                catch (Exception ee) {
//                	logger.info("JSON转换错误" + ee.toString());
//                }
//            }
//            参数
            sb1.append(JSON.toJSONString(args));
            
            StringBuilder sb2 = new StringBuilder();
            StackTraceElement[] stackTraces = e.getStackTrace();
            for (StackTraceElement stack : stackTraces) {
                sb2.append(stack.toString()).append(lineBreak);
            }

//            MailSendUtil.sendMail("时间："
//                    + lineBreak + time + lineBreak + "<br></br><p style='color:red;'>参数:</p>" + lineBreak + sb1 + "<br></br>异常:"
//                    + e.toString() + "<br></br>详细信息:" + sb2);
            
            System.out.println("e.toString():" + e.toString());
            System.out.println(e.hashCode());
            
            System.out.println("时间："
                    + lineBreak + time + lineBreak + "<br></br>参数:" + lineBreak + sb1 + "<br></br>异常:"
                    + e.toString() + "<br></br>" + sb2);
            
            System.out.println("JSON.toJSONString(stackTraces):");
            System.out.println(JSON.toJSONString(stackTraces));
            System.out.println("sb2:");
            System.out.println(sb2);
            System.out.println(sb2.toString().equals(JSON.toJSONString(stackTraces)));

            throw e;
        }
    }


    /*
进入方法---环绕通知
前置通知
退出方法---环绕通知
最终通知
后置通知
---123---
     */

}
