package com.chengzi.art.school.oa.init;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;

/**
 * 服务器的配置
 * Created by zhouwei on 2018/12/24
 **/
@Configuration
public class WebServerConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory>{

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
    }

}
