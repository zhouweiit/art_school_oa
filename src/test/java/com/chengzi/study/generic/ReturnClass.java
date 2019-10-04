package com.chengzi.study.generic;

public class ReturnClass {

    public <T> T returnTest() {
        return null;
    }

}

interface Teacher {
    <E> E test();
}

class TeacherImpl implements Teacher {
    @Override
    public <Integer> Integer test() {
        return null;
    }
}

class TeacherImpl2 implements Teacher {
    @Override
    public <Object> Object test() {
        return null;
    }
}

class Student {

    public Student get() {//看看test1的类型是如何自动推算出来的？？
        return test1();
    }



    public <T> T test1() {
        TeacherImpl tl = new TeacherImpl();
        return tl.test();
    }
}
