package com.chengzi.art.school.oa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Controller
@RequestMapping("/admin/login")
public class LoginController {

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hello", "hello world");
        mav.setViewName("/view/admin/login/index");
        return mav;
    }

}
