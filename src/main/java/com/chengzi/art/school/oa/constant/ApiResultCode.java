package com.chengzi.art.school.oa.constant;

import lombok.Getter;

@Getter
public enum ApiResultCode {

    NOT_LOGIN(88, "用户未登录或者登录超市");

    private int code;

    private String message;

    ApiResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
