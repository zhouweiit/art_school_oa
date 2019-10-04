package com.chengzi.art.school.oa.config;

import com.chengzi.art.school.oa.config.interceptors.MenuWebRequestInterceptor;
import com.chengzi.art.school.oa.config.interceptors.PermissionHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by zhouwei on 2018/12/24
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionHandlerInterceptor());
        registry.addWebRequestInterceptor(new MenuWebRequestInterceptor());
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/webapp/static/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/webapp/static/favicon.ico");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/webapp/templates/");
    }

}
