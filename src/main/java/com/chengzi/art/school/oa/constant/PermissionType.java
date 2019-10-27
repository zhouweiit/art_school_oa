package com.chengzi.art.school.oa.constant;

import lombok.Getter;

@Getter
public enum PermissionType {

    FirstMenu(1, "一级菜单"),
    SecondMenu(2, "二级菜单"),
    Button(3, "按钮"),
    Date(4, "数据"),
    Other(5, "其他");

    private Integer id;

    private String name;

    PermissionType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
