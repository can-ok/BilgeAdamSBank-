package com.aop.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.aop.demo.service.MessageService.sendMessage(..))")
    public void beforeShowMessage(JoinPoint joinPoint){
        System.out.println("before: "+joinPoint.getArgs()[0]);
        System.out.println("Signature: " +joinPoint.getSignature());
    }

    @After("execution(* com.aop.demo.service.*.*(..))")
    public void  afterShowMessage(JoinPoint joinPoint){
        System.out.println("after: "+joinPoint.getArgs()[0]);
        System.out.println("Signature: " +joinPoint.getSignature());
    }
}
