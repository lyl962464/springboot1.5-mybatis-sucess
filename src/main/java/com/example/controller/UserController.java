package com.example.controller;

import com.example.model.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /***
     *  controller层返回值类型为Integer，然而报 Unknown return value type: java.lang.Integer 这个错误，500错误
     解决办法：在此方法上写上注解@ResponseBody就没问题了。
     * @param user
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public int getUser(User user){
        return userService.insert(user);
    }


}
