package com.chengzi.art.school.oa.config;

import com.chengzi.art.school.oa.config.interceptors.MenuInterceptor;
import com.chengzi.art.school.oa.config.interceptors.PermissionInterceptor;
import com.chengzi.art.school.oa.config.interceptors.SessionInterceptor;
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
        registry.addInterceptor(new SessionInterceptor());
        registry.addInterceptor(new PermissionInterceptor());
        registry.addWebRequestInterceptor(new MenuInterceptor());
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
