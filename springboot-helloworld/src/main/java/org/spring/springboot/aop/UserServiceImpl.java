package org.spring.springboot.aop;

import org.springframework.util.StringUtils;

/**
 * 接收请求报价消息的测试类
 *
 * @author yigang.wu
 * @date created in ${time} ${date}
 */
public class UserServiceImpl implements UserService{

    public void printStr(String str){
        try {
            StringUtils.isEmpty(str);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        System.out.println("this method is start");
        System.out.println(str);
        System.out.println("the method is end");
    }
}
