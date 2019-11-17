package com.chengzi.art.school.oa.controller.admin;

import com.chengzi.art.school.framework.api.ApiResultDto;
import com.chengzi.art.school.framework.util.CaptchaUtil;
import com.chengzi.art.school.framework.util.SafeConverterUtil;
import com.chengzi.art.school.oa.config.AppConfig;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.SchoolGroup;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserAuth;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserBase;
import com.chengzi.art.school.oa.service.LoginService;
import com.chengzi.art.school.oa.service.SchoolGroupService;
import com.chengzi.art.school.oa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

@Controller
@RequestMapping("/admin/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private SchoolGroupService schoolGroupService;

    @RequestMapping(value = "/view", method = {RequestMethod.GET})
    public ModelAndView view(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Boolean isLogin = SafeConverterUtil.toBoolean(session.getAttribute(AppConfig.Login.isLoginSessionKey));
        if (isLogin) {
            response.sendRedirect("/admin/index/view");
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/view/admin/login/view");
        return mav;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultDto login(String username, String password, String captcha, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(AppConfig.Login.sessionTimeout);
        String captchaSession = SafeConverterUtil.toString(session.getAttribute(AppConfig.Login.captchaSessionKey));
        session.setAttribute(AppConfig.Login.captchaSessionKey, "");
        if (!Objects.equals(captcha, captchaSession)) {
            return ApiResultDto.getInstanceError400("验证码错误，请重新输入");
        }
        UserAuth userAuth = loginService.checkUserPassword(username, password);
        if (null == userAuth) {
            return ApiResultDto.getInstanceError400("用户名或者密码错误，请重新输入");
        }
        UserBase userBase = userService.loadUserBaes(userAuth.getUserBaseId());
        SchoolGroup schoolGroup = schoolGroupService.loadSchoolGroupById(userBase.getSchoolGroupId());
        session.setAttribute(AppConfig.Login.isLoginSessionKey, true);
        session.setAttribute(AppConfig.Login.userIdSessionKey, userAuth.getUserBaseId());
        session.setAttribute(AppConfig.Login.userNameSessionKey, userBase.getName());
        session.setAttribute(AppConfig.Login.userSchoolGroupNameSessionKey, schoolGroup.getName());
        return ApiResultDto.getInstance200();
    }

    @RequestMapping(value = "/captcha", method = {RequestMethod.GET})
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(AppConfig.Login.sessionTimeout);
        int width = AppConfig.Login.captchaWidth;
        int height = AppConfig.Login.captchaHeight;
        BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        String randomText = CaptchaUtil.drawRandomText(width, height, verifyImg);
        session.setAttribute(AppConfig.Login.captchaSessionKey, randomText);
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(verifyImg,"png", os);
        os.flush();
        os.close();
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultDto logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (null != session) {
            session.invalidate();
        }
        return ApiResultDto.getInstance200();
    }

}
