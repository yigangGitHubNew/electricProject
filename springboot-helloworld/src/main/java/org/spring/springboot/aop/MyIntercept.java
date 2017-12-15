package org.spring.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * 自己定义的拦截器
 */
@Aspect
@Component
public class MyIntercept {

    private static final Logger logger = LoggerFactory.getLogger(MyIntercept.class);

    public Object interceptor(ProceedingJoinPoint pjp){
        Long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        logger.info("this method name is: "+methodName);
        return null;
    }


    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void  beforeTest(RequestMapping rp){
        System.out.println("before run the method name is "+rp.name());
    }

    @After("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void afterTest(RequestMapping rp){
        System.out.println("after run the method name is "+rp.name());
    }
}
