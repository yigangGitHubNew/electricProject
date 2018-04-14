package org.gd.sbc.electric.controller;

import org.gd.sbc.electric.entity.RestResponse;
import org.gd.sbc.electric.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yigang.wu
 * @date created in $time $date
 */
@RestController
@RequestMapping(value = "/helloWorld")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public RestResponse<String> helloWorld(){
        RestResponse<String> response = new RestResponse<String>();
        response.setT("Hello World");
        response.setErrorCode("0");
        response.setErrorMsg("This is right");
        helloWorldService.printHelloWorld();
        return response;
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
