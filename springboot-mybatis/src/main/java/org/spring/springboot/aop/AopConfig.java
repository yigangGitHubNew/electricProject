package org.spring.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * 接收请求报价消息的测试类
 *
 * @author yigang.wu
 * @date created in ${time} ${date}
 */
@Aspect
@Configuration
public class AopConfig {
    @Pointcut("execution(* org.spring.springboot.service.CityService.findCityByName(..))")
    public void excudeService(){}

   /* @Before("excudeService()")
    public void before() {
        System.out.println("切面before执行了");
    }

    @After("excudeService()")
    public void after() {
        System.out.println("切面after执行了");
    }

    @AfterReturning("excudeService()")
    public void afterReturning() {
        System.out.println("切面afterReturning执行了");
    }

    @AfterThrowing("excudeService()")
    public void afterThrowing() {
        System.out.println("切面afterThrowing执行了");
    }*/

    @Around("excudeService()")
    public Object around(ProceedingJoinPoint thisJoinPoint){
        Object obj = null;
        System.out.println ("切面around before执行了");
        try {
            Object[] objs = thisJoinPoint.getArgs();
            if(StringUtils.isEmpty(objs[0].toString())){
                objs[0] = "abc";
            }
            System.out.println("the agrs is:"+objs[0].toString());
            obj = thisJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace ();
        }
        System.out.println ("切面around after执行了");
        return obj;
    }

}
