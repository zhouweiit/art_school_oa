package com.chengzi.art.school.oa.constant;

/**
 * Created by zhouwei on 2018/12/24
 **/
public enum UserType {

    Teacher(1, "老师"),

    Student(2, "学生"),

    SchoolMaster(3, "校长"),

    Other(4, "其他");

    private Integer id;

    private String name;

    UserType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
