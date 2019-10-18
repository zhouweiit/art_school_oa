package com.chengzi.art.school.oa.controller.front;

import com.chengzi.art.school.oa.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexFrontController extends FrontAbstractController {

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

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test() throws Exception {
        throw new Exception("/test exception");
    }

    @RequestMapping(value = "/500", method = {RequestMethod.GET})
    @ResponseBody
    public String page500() throws Exception {
        return "500";
    }

    @RequestMapping(value = "/400", method = {RequestMethod.GET})
    @ResponseBody
    public String page400() throws Exception {
        return "400";
    }
}
