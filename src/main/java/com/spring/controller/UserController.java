package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.domain.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        modelAndView.addObject("username", "leon");
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/test4", method = RequestMethod.GET, params = {"username"})
    public ModelAndView test4(ModelAndView modelAndView) {
        System.out.println("Controller test4 running...");
        modelAndView.addObject("username", "yoyo");
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/test5", method = RequestMethod.GET, params = {"username"})
    public String test5(Model model) {
        System.out.println("Controller test5 running...");
        model.addAttribute("username", "qiqi");

        return "success";
    }

    @RequestMapping(value = "/test6", method = RequestMethod.GET, params = {"username"})
    public String test6(HttpServletRequest httpRequest) {
        httpRequest.setAttribute("username", "璐璐");

        return "success";
    }

    /*
     * 回写服务器
     * */
    @RequestMapping(value = "test7")
    public void test7(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.getWriter().print("hello leon");
    }

    @RequestMapping(value = "test8")
    @ResponseBody
    public String test8(HttpServletResponse httpServletResponse) throws IOException {

        return "hello leon8";
    }

    /*
    * 回写 json
    * */
    @RequestMapping(value = "test9")
    @ResponseBody
    public String test9(HttpServletResponse httpServletResponse) throws IOException {
        User user = new User("leon", 22);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping(value = "test10")
    @ResponseBody
    public User test10(HttpServletResponse httpServletResponse) throws IOException {
        User user = new User("leon", 22);
        return user;
    }
}
