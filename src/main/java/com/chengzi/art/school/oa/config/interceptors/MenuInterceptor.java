package com.chengzi.art.school.oa.config.interceptors;

import org.springframework.lang.Nullable;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by zhouwei on 2018/12/29
 **/
public class MenuInterceptor implements WebRequestInterceptor{

    @Override
    public void preHandle(WebRequest request) throws Exception {
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
    }

}
