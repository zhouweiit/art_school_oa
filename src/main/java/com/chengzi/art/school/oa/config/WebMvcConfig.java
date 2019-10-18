package com.chengzi.art.school.oa.config;

import com.chengzi.art.school.oa.config.interceptors.MenuInterceptor;
import com.chengzi.art.school.oa.config.interceptors.ParamsInitInterceptor;
import com.chengzi.art.school.oa.config.interceptors.PermissionInterceptor;
import com.chengzi.art.school.oa.config.interceptors.SessionInterceptor;
import com.google.common.collect.Lists;
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
        List<String> excludePathPatterns = Lists.newArrayList("/static/**", "/favicon.ico");
        registry.addInterceptor(new ParamsInitInterceptor()).excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(new SessionInterceptor()).excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(new PermissionInterceptor()).excludePathPatterns(excludePathPatterns);
        registry.addInterceptor(new MenuInterceptor()).excludePathPatterns(excludePathPatterns);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/favicon.ico");
    }

}
