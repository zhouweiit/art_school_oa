package com.chengzi.study.lambda;

public interface InterfaceD {

    void test();

    default void testA() {
        System.out.println("interfaced default testA");
    }

}

class A implements InterfaceD {

    @Override
    public void test() {
        testA();
    }
}