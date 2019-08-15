package com.chengzi.study.lambda;

public class InterfaceBImpl implements InterfaceB{

    @Override
    public void test(People a, People b) {
        System.out.println(a);
        System.out.println(b);
    }

}
