package com.chengzi.art.school.oa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Controller
@RequestMapping("/admin/demo")
public class DemoController {

    @RequestMapping(value = "/table", method = {RequestMethod.GET})
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/demo/table");
        return mav;
    }

    @RequestMapping(value = "/form", method = {RequestMethod.GET})
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/demo/form");
        return mav;
    }
}
