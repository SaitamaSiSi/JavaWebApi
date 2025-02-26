package com.zyh.javawebapi;

/**
 * 功能
 * 作者：Zyh
 * 日期：2025年02月14日
 */
public class Result<T> {
    public Integer code;
    public String msg;
    public T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
