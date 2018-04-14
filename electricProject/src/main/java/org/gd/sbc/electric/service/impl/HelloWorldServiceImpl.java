package org.gd.sbc.electric.service.impl;

import org.gd.sbc.electric.service.HelloWorldService;
import org.springframework.stereotype.Component;

/**
 * @author yigang.wu
 * @date created in $time $date
 */
@Component
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public void printHelloWorld() {
        System.out.println("The background print Hello World");
    }
}
