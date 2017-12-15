package org.spring.springboot.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 接收请求报价消息的测试类
 *
 * @author yigang.wu
 * @date created in ${time} ${date}
 */
public class TestAopProxyFactory {

    public static void main(String[] args) {
        MethodBeforeAdvice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("the method name is :"+method.getName());
                System.out.println("the args is :"+args[0].toString());
                System.out.println(method.getExceptionTypes());
            }
        };
        UserServiceImpl userService = new UserServiceImpl();
        UserService userService1 = (UserService)AOPProxyFactory.createProxy(userService,advice);
        userService1.printStr("");
    }
}
