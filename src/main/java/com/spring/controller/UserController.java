package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class UserController {

    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running...");
        return "success";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET, params = {"username"})
    public String test1() {
        System.out.println("Controller test1 running...");
        return "forward:/test/success.jsp";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET, params = {"username"})
    public String test2() {
        System.out.println("Controller test2 running...");
        return "redirect:/test/success.jsp";
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET, params = {"username"})
    public ModelAndView test3() {
        /*
            Model: 模型 作用封装数据
            View: 视图 作用展示数据
         */
        System.out.println("Controller test3 running...");
        ModelAndView modelAndView = new ModelAndView();
        /*
        * 设置视图
        * */
        modelAndView.addObject("username","leon");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/test4", method = RequestMethod.GET, params = {"username"})
    public ModelAndView test4(ModelAndView modelAndView) {
        System.out.println("Controller test4 running...");
        modelAndView.addObject("username","yoyo");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
