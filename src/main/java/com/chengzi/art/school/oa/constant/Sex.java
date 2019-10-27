package com.chengzi.art.school.oa.constant;

import lombok.Getter;

@Getter
public enum Sex {

    Boy(1, "男"),

    Girl(2, "女");

    private Integer id;

    private String name;

    Sex(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
