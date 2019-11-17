package com.chengzi.art.school.oa.controller.admin.org;

import com.chengzi.art.school.framework.api.ApiResultDto;
import com.chengzi.art.school.framework.util.SafeConverterUtil;
import com.chengzi.art.school.oa.config.AppConfig;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.UserAuth;
import com.chengzi.art.school.oa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/admin/org/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/modify_password", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResultDto modifyPassword(String oldPassword, String firstPassword, String secondPassword, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer userBaseId = SafeConverterUtil.toInteger(session.getAttribute(AppConfig.Login.userIdSessionKey));
        UserAuth userAuth = userService.loadUserAuth(userBaseId);
        String password = UserAuth.createPassword(userAuth.getSalt(), oldPassword);
        if (!Objects.equals(password, userAuth.getLoginPassword())) {
            return ApiResultDto.getInstanceError400("旧密码输入错误，请重新输入");
        }
        if (!Objects.equals(firstPassword, secondPassword)) {
            return ApiResultDto.getInstanceError400("新密码两次输入的密码不一致，请重新输入");
        }
        userService.updateUserPassword(userAuth.getUserBaseId(), userAuth.getSalt(), firstPassword);
        return ApiResultDto.getInstance200();
    }

}
