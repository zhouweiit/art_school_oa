package com.chengzi.art.school.framework.util.date;

import lombok.Getter;

/**
 * Created by zhouwei on 2019/10/16
 **/
public enum DateFormat {

    yyyyMMdd("yyyy-MM-dd"),
    HHmmss("HH:mm:ss"),
    yyyyMMddHHmmss("yyyy-MM-dd HH:mm:ss"),
    yyyyMM("yyyy-MM"),
    MMdd("MM-dd"),
    HHmm("HH:mm"),
    mmss("mm:ss");

    @Getter
    private String pattern;

    DateFormat(String pattern) {
        this.pattern = pattern;
    }

    public String toString() {
        return name() + ":" + pattern;
    }
}
