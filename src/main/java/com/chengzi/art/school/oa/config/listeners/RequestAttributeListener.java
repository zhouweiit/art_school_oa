package com.chengzi.art.school.oa.config.listeners;

import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener("RequestAttributeListener")
@Configuration
public class RequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent srae) {
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
    }

}
