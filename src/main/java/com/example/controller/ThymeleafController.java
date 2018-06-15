package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class ThymeleafController {

    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        // 设置属性
        view.addObject("title", "我的第一个WEB页面");
        view.addObject("desc", "欢迎进入Luis-web 系统");

        Author author = new Author();
        author.setAge(24);
        author.setEmail("1085143002@qq.com");
        author.setAuthorName("Luis");
        view.addObject("author", author);
        return view;

    }
    @GetMapping(value = "/index1")
    public String index1(HttpServletRequest request){
        // 设置属性
        request.setAttribute("title", "我的第一个WEB页面");
        request.setAttribute("desc", "欢迎进入Luis-web 系统");

        Author author = new Author();
        author.setAge(24);
        author.setEmail("1085143002@qq.com");
        author.setAuthorName("Luis");
        request.setAttribute("author", author);
        return "index";
    }


    class Author{
        /***
         * 姓名
         */
        private String authorName;
        /***
         * 邮箱
         */
        private String email;
        /**
         * 年龄
         */
        private int age;

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
