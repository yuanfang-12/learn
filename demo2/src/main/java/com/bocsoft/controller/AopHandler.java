package com.bocsoft.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.awt.*;

@Aspect
//@Component
public class AopHandler {

    @Pointcut("@annotation(com.bocsoft.annotation.Aopdemo)")
    public void returnPoint(){};

    @Pointcut("execution(* com.bocsoft..*())")
    public void exePoint(){};

    @Pointcut("within(com.bocsoft.controller.DemoController)")
    public void withinPoint(){};

    @Pointcut("args(java.lang.String) && within(com.bocsoft.controller.DemoController)")
    public void argsPoint(){};



    @Before("argsPoint()")
    public void beforeAnnotaion(JoinPoint joinPoint){
        joinPoint.getArgs();
    }

    @AfterReturning(value = "argsPoint()", returning = "ex")
    public void afterAnnotaionR(Object ex, JoinPoint joinPoint){
        System.out.println("afterAnnotaionR");
    }

    @AfterThrowing(value = "argsPoint()", throwing = "exception")
    public void afterAnnotaionT(Exception exception, JoinPoint joinPoint){
        System.out.println("afterAnnotaionT");
        exception.getMessage();
    }

    @After("argsPoint()")
    public void afterAnnotaion(JoinPoint joinPoint){
        System.out.println("afterAnnotaion");
    }

    @Around("argsPoint()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("beforeAnnotaionA");
        Object[] args = joinPoint.getArgs();
        try {
            joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("afterAnnotaionA");
    }

}
