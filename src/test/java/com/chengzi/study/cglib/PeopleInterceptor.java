package com.chengzi.study.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhouwei on 2019/8/13
 **/
public class PeopleInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        System.out.println("start proxy");
        Object result = methodProxy.invokeSuper(o, params);
        System.out.println("end proxy");
        return result;
    }
}
