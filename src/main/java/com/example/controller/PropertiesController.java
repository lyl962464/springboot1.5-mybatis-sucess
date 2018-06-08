package com.example.controller;

import com.example.properties.MyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来注入MyProperties1测试我们编写的代码，值得注意的是Spring4.x以后，推荐使用构造函数的形式注入属性…
 */
@RequestMapping(value = "/properties")
@RestController
public class PropertiesController {
    private static final Logger log = LoggerFactory.getLogger(PropertiesController.class);

    private final MyProperties myProperties;

    public PropertiesController(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    @GetMapping(value = "getProperties")
    public MyProperties getMyProperties(){
        log.info("========================================");
        log.info(myProperties.toString());
        log.info("========================================");
        return  myProperties;
    }

}
