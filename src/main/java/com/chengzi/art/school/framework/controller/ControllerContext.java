package com.chengzi.art.school.framework.controller;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhouwei on 2019/10/18
 **/
@Data
public class ControllerContext {

    private HttpServletRequest request;

    private HttpServletResponse response;

}
