package com.chengzi.art.school.oa.controller.admin;

import com.chengzi.art.school.framework.util.CaptchaUtil;
import com.chengzi.art.school.oa.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
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

@Controller
@RequestMapping("/admin/login")
@Slf4j
public class LoginAdminController {

    @RequestMapping(value = "/view", method = {RequestMethod.GET})
    @ResponseBody
    public String view() {
        return "请登录";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    @ResponseBody
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (null != session) {
            session.invalidate();
        }
        return "logout";
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

    @RequestMapping(value = "/mock", method = {RequestMethod.GET})
    @ResponseBody
    public String mock(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(AppConfig.Login.sessionTimeout);
        session.setAttribute(AppConfig.Login.isLoginSessionKey, true);
        session.setAttribute(AppConfig.Login.userIdSessionKey, 1);
        return "您已经登录";
    }

}
