package com.chengzi.art.school.oa.config.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试自定义servlet
 */
//@WebServlet(name = "testServlet", urlPatterns = "/test/servlet")
//@Configuration
//Multiple servlets map to path /: dispatcherServlet[mapped:JAVAX_API:null],testServlet[mapped:JAVAX_API:null]
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("test servlet").flush();
    }

}
