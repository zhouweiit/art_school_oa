package com.chengzi.art.school.oa.config;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

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
        session.setTimeout(Duration.ofSeconds(30));
        factory.setPort(port);
        factory.setSession(session);

        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
        factory.addErrorPages(errorPage404, errorPage500);
    }

}
