package com.chengzi.art.school.oa.controller.admin.teaching;

import com.chengzi.art.school.oa.controller.admin.AdminAbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/teaching/student")
@Slf4j
public class StudentController extends AdminAbstractController {

    @RequestMapping(value = "/view", method = {RequestMethod.GET})
    public ModelAndView view() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/teaching/student/view");
        return mav;
    }

}
