package com.chengzi.study.seria;

import java.io.Serializable;

/**
 * Created by zhouwei on 2018/10/29
 **/
public class Person implements Serializable{
    private static final long serialVersionUID = 123456789L;
    public int id;
    public String name;
    public int aaa;
    public int bbb;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Person: " + id + " " + name;
    }
}
