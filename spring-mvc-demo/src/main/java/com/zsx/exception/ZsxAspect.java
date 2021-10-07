package com.zsx.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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


    @Before(EDP)
    public void logBefore(JoinPoint joinPoint){
        System.out.println("=============");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.debug(className + "的" + methodName + "执行了");
        System.out.println(className + "的" + methodName + "执行了");
        Object[] args = joinPoint.getArgs();
        StringBuilder log = new StringBuilder("入参为");
        for (Object arg : args) {
            log.append(arg + " ");
        }
        logger.debug(log.toString());
        System.out.println(log.toString());
    }




}
