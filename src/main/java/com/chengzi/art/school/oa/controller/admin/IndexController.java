package com.chengzi.art.school.oa.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
@Slf4j
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "/admin/index/view";
    }

    @RequestMapping(value = "/index/view", method = {RequestMethod.GET})
    public ModelAndView view() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/index/view");
        return mav;
    }

}
