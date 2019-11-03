package com.chengzi.art.school.oa.config.interceptors;

import com.chengzi.art.school.framework.util.SafeConverterUtil;
import com.chengzi.art.school.oa.Launch;
import com.chengzi.art.school.oa.config.AppConfig;
import com.chengzi.art.school.oa.dto.response.MenuTreeDto;
import com.chengzi.art.school.oa.persistence.mysql.artoa.model.PermissionResource;
import com.chengzi.art.school.oa.service.PermissionService;
import com.chengzi.art.school.oa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by zhouwei on 2018/12/29
 **/
@Slf4j
public class MenuInterceptor implements HandlerInterceptor {

    private PermissionService permissionService;

    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            permissionService = Launch.getContext().getBean(PermissionService.class);
            userService = Launch.getContext().getBean(UserService.class);
            return true;
        } catch (Exception e) {
            log.error("errorMessage:{}, url:{}", e.getMessage(), request.getRequestURL(), e);
            response.sendRedirect("/500");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            if (null != modelAndView) {
                HttpSession session = request.getSession(true);
                Integer userBaseId = SafeConverterUtil.toInteger(session.getAttribute(AppConfig.Login.userIdSessionKey));
                Set<PermissionResource> permissionResources = userService.loadUserPermission(userBaseId);
                List<MenuTreeDto> menuTreeDto = permissionService.createMenuTreeDto(permissionResources);
                modelAndView.addObject("_menu_dto_key_", menuTreeDto);
                modelAndView.addObject("_servlet_path_", request.getServletPath());
            }
        } catch (Exception e) {
            response.sendRedirect("/500");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
