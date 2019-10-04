package com.chengzi.art.school.oa.controller.admin;

import com.chengzi.art.school.oa.persistence.mysql.oa.dao.StudentDao;
import com.chengzi.art.school.oa.persistence.mysql.oa.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public ModelAndView login() {
        teacherDao.getById(1);
        studentDao.getById(1);
        ModelAndView mav = new ModelAndView();
        mav.addObject("hello", "hello world");
        mav.setViewName("/view/admin/login/index");
        return mav;
    }

}
