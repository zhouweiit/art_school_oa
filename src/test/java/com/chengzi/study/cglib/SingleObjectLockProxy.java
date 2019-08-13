package com.chengzi.study.cglib;


import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * Created by zhouwei on 2019/8/13
 **/
public class SingleObjectLockProxy<T>{

    private Class<T> tClass;


    public SingleObjectLockProxy(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T proxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.tClass);
        enhancer.setCallback(new PeopleInterceptor());
        T tc = (T)enhancer.create();
        return tc;
    }

}
