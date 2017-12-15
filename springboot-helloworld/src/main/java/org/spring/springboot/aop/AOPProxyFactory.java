package org.spring.springboot.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  aop代理工厂
 */
public class AOPProxyFactory {

    public static Object createProxy(final Object target, final MethodBeforeAdvice beforeAdvice){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                beforeAdvice.before(method,args,target);
                return method.invoke(target,args);
            }
        });
    }
}
