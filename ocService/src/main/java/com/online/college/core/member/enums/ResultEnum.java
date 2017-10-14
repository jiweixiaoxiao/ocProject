package com.online.college.core.member.enums;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-10
 * Time: 13:43
 */
@Getter
public enum ResultEnum {
    SUCCESS("100","成功"),
    ERROR("101","失败");

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
