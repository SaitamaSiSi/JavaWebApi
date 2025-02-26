package com.zyh.javawebapi.enums;

/**
 * 功能
 * 作者：Zyh
 * 日期：2025年02月14日
 */
public enum ResultEnum {
    ERROR(-1,"ERROR---------"),
    SUCCESS(100,"SUCCESS--------"),
    ;
    //这样就说明我们具有ERROR和SUCCESS两种状态，成功时返回100，SUCCESS

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
