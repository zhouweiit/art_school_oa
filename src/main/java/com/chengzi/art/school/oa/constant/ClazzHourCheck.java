package com.chengzi.art.school.oa.constant;

public enum ClazzHourCheck {

    CheckIn(1, "到课"),
    NoCheckIn(2, "未到"),
    AskForLeave(3, "请假");

    private Integer id;

    private String name;

    ClazzHourCheck(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
