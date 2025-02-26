package com.zyh.javawebapi.utils;

import com.zyh.javawebapi.Result;
import com.zyh.javawebapi.enums.ResultEnum;

/**
 * 功能
 * 作者：Zyh
 * 日期：2025年02月14日
 */
public class ResultUtil {
    //对应我们在Enum中设置的两种状态
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.ERROR.getCode());
        result.setMsg(ResultEnum.ERROR.getMsg());
        result.setData(data);
        return result;
    }
}
