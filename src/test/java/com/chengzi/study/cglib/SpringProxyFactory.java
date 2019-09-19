package com.chengzi.study.cglib;

/**
 * Created by zhouwei on 2019/8/13
 **/
public class SpringProxyFactory {

    public static void main(String[] args) throws InterruptedException {
        SingleObjectLockProxy<People> singleObjectLockProxy = new SingleObjectLockProxy<>(People.class);
        People p = singleObjectLockProxy.proxy();
        p.eat();
    }

}
