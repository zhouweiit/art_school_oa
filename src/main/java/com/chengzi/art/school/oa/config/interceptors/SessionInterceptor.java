package com.chengzi.art.school.oa.config.interceptors;

import com.chengzi.art.school.framework.util.SafeConverterUtil;
import com.chengzi.art.school.oa.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
    注意要理解一个东西：
    1. http session提供的过期时间，清除session并不会去清除客户端的cookie，只会清除内存中的session信息
    2. session的cookie过期时间默认是浏览器的关闭时间, 暂时没找到怎么设置
*/
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {

            //todo 判断是否是ajax，如果是的话，需要返回ApiResultDto，以及固定的code

            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(AppConfig.Login.sessionTimeout);
            Boolean isLogin = SafeConverterUtil.toBoolean(session.getAttribute(AppConfig.Login.isLoginSessionKey), false);
            if (!isLogin) {
                response.sendRedirect("/admin/login/view");
                return false;
            }
            return true;
        } catch (Exception e) {
            log.error("errorMessage:{}, url:{}", e.getMessage(), request.getRequestURL(), e);
            response.sendRedirect("/500");
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
