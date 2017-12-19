package org.spring.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/world")
    public String sayHello() {
        System.out.println("Hello World");
        return "Hello,World!";
    }
}
