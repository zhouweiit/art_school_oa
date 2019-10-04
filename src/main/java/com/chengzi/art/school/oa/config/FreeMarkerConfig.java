package com.chengzi.art.school.oa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * freemark的全局变量配置
 */
@Configuration
public class FreeMarkerConfig{

    @Bean
    public FreeMarkerViewResolver getFreeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setCache(false);
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");

        Map<String, Object> globalVar = new HashMap<>();
        globalVar.put("layout_admin_path", "../../../layout/admin");
        freeMarkerConfigurer.setFreemarkerVariables(globalVar);
        return freeMarkerConfigurer;
    }

}
