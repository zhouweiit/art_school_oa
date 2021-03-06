package com.chengzi.art.school.oa.constant;

import lombok.Getter;

@Getter
public enum Subject {

    Painting(1, "美术");

    private Integer id;

    private String name;

    Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
