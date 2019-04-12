package com.zsx.web.config;

import com.alibaba.fastjson.JSON;
import com.zsx.web.util.CacheUtil;
import com.zsx.web.util.SpringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by ZSX on 2018/1/24.
 *
 * @author ZSX
 */
public class CacheAspect {

    public CacheAspect() {
//        System.out.println("实例化 CacheAspect");
    }

    public void afterReturning(JoinPoint joinPoint, Object returnVal) {

//        System.out.println("返回值为：" + JSON.toJSONString(returnVal));

        // 目标类
        Object target = joinPoint.getTarget();
        // 目标类Class字节码
        Class<?> targetClass = target.getClass();
        // 目标方法的签名
        Signature signature = joinPoint.getSignature();
        // 目标方法名
        String methodName = signature.getName();
        // 目标方法的参数类型数组
        Class<?>[] parameterTypes = ((MethodSignature) signature).getMethod().getParameterTypes();

        try {
            MyAnno myAnno = null;
            Method method = targetClass.getMethod(methodName, parameterTypes);
            if (method != null && method.isAnnotationPresent(MyAnno.class)) {
                // 获取方法上的数据源设置
                myAnno = method.getAnnotation(MyAnno.class);
            } else if (targetClass.isAnnotationPresent(MyAnno.class)) {
                // 获取类上的数据源设置
                myAnno = targetClass.getAnnotation(MyAnno.class);
            }
            if (myAnno != null) {
                CacheUtil.CacheEnum cacheEnum = myAnno.value();

                CacheUtil cacheUtil = SpringUtil.getBean(CacheUtil.class);
//                刷新缓存
                cacheUtil.refreshCache(cacheEnum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
