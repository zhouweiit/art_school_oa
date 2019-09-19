package com.chengzi.study.lambda;

import java.util.function.Consumer;

/**
 * Created by zhouwei on 2019/9/10
 **/
public class ConsumerFor {

    public static void main(String[] args) {
        Consumer<Integer> consumer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("first x : " + integer);
            }
        };


        Consumer<Integer> consumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("second x : " + integer);
            }
        };

        Consumer<Integer> consumer3 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("third x : " + integer);
            }
        };

        Consumer<Integer> integerConsumer1 = consumer1.andThen(consumer2);

        // A的accept方法
        // (T t) -> { accept(t) //执行first; after.accept(t); //执行second};

        Consumer<Integer> integerConsumer2 = integerConsumer1.andThen(consumer3);

        // B的accept方法
        // (T t) -> { accept(t) //执行A的accept方法; after.accept(t); //执行third};

        integerConsumer2.accept(1);
    }

}
