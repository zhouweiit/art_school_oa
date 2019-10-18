package com.chengzi.art.school.oa.config.interceptors;

import com.chengzi.art.school.framework.controller.ControllerContext;
import com.chengzi.art.school.oa.controller.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

/**
 * Created by zhouwei on 2019/10/18
 **/
@Slf4j
public class ParamsInitInterceptor extends AbstractInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.getBean() instanceof AbstractController) {
                AbstractController controller = (AbstractController) handlerMethod.getBean();
                Field field = AbstractController.class.getDeclaredField("controllerContext");
                if (null == field) {
                    log.error("AbstractController's controllerContext miss");
                    return false;
                }
                field.setAccessible(true);
                ControllerContext controllerContext = new ControllerContext();
                controllerContext.setRequest(request);
                controllerContext.setResponse(response);
                field.set(controller, controllerContext);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        try {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.getBean() instanceof AbstractController) {
                AbstractController controller = (AbstractController) handlerMethod.getBean();
                Field field = AbstractController.class.getDeclaredField("controllerContext");
                if (null == field) {
                    log.error("AbstractController's controllerContext miss");
                }
                field.setAccessible(true);
                field.set(controller, null);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
