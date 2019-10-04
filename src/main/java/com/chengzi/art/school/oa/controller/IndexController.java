package com.chengzi.art.school.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/front/index");
        return mav;
    }

    @RequestMapping(value = "/admin", method = {RequestMethod.GET})
    public ModelAndView adminIndex() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/index");
        return mav;
    }

}
