package com.chengzi.study.serviceload;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        ServiceLoader<Test> load = ServiceLoader.load(Test.class);
        Iterator<Test> iterator = load.iterator();
        while (iterator.hasNext()) {
            Test next = iterator.next();
            next.hello();
        }

    }

}
