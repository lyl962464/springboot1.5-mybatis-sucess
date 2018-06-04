package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * 异常控制类
 *
 *
 * @ControllerAdvice 会拦截所有controller注解的控制器
 *
 *
 */

@ControllerAdvice
public class ControllerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionhandler(HttpServletRequest request, Exception e) throws Exception {
        logger.error("request URL : {}, Exception : {}",request.getRequestURI(),e);
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("url",request.getRequestURI());
        mav.addObject("exception",e);
        mav.setViewName("error/404");
        return mav;
    }


}
