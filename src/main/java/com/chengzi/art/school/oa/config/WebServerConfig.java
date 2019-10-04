package com.chengzi.art.school.oa.config;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * 服务器的配置
 * Created by zhouwei on 2018/12/24
 **/
@Configuration
public class WebServerConfig implements WebServerFactoryCustomizer<JettyServletWebServerFactory> {

    private static final Integer port = 9000;

    @Override
    public void customize(JettyServletWebServerFactory factory) {
        Session session = new Session();
        session.setTimeout(Duration.ofMinutes(3));
        factory.setPort(port);
        factory.setSession(session);
    }

}
