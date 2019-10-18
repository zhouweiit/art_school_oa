package com.chengzi.art.school.oa.config.interceptors;

import com.chengzi.art.school.oa.Launch;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Created by zhouwei on 2019/10/18
 **/
public class AbstractInterceptor implements HandlerInterceptor {

    protected ApplicationContext context;

    protected Environment env;

    {
        context = Launch.getContext();
        env = Launch.getEnv();
    }

}
