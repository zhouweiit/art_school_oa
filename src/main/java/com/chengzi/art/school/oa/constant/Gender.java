package com.chengzi.art.school.oa.constant;

import lombok.Getter;

@Getter
public enum Gender {

    Unkonw(0, "未知"),

    Boy(1, "男"),

    Girl(2, "女");

    private Integer id;

    private String name;

    Gender(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
