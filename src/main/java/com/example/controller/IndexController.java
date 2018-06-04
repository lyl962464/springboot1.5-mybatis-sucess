package com.example.controller;

import com.example.exception.NotFundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(){

        String url = null;
        if (url == null) {
            throw new NotFundException("找不到指定的页面");
        }

        return "index";
    }

}
