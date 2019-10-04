package com.chengzi.art.school.oa.config.listeners;

import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener("RequestListener")
@Configuration
public class RequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent event) {
    }

    public void requestDestroyed(ServletRequestEvent event) {
    }

}
