package com.chengzi.art.school.oa.controller;

import com.chengzi.art.school.framework.controller.ControllerContext;
import com.chengzi.art.school.oa.Launch;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Created by zhouwei on 2019/10/18
 **/
abstract public class AbstractController {

    protected ApplicationContext context;

    protected Environment env;

    protected ControllerContext controllerContext;

    {
        context = Launch.getContext();
        env = Launch.getEnv();
    }

}
