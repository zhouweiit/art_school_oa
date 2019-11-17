package com.chengzi.art.school.oa.controller.admin.finace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/finace/signup")
@Slf4j
public class SignupController {

    @RequestMapping(value = "/view", method = {RequestMethod.GET})
    public ModelAndView view() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/finace/signup/view");
        return mav;
    }

}
