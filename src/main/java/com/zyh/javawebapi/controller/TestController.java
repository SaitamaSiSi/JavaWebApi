package com.zyh.javawebapi.controller;

import com.zyh.javawebapi.Result;
import com.zyh.javawebapi.database.DataSourceConfig;
import com.zyh.javawebapi.entity.DictCatgEntity;
import com.zyh.javawebapi.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 功能
 * 作者：Zyh
 * 日期：2025年02月14日
 */
@RestController
@RequestMapping("/api")
public class TestController {
    DataSourceConfig dataSourceConfig = new DataSourceConfig();

    @PostMapping("/postTest")
    public Result<String> postTest(@RequestBody boolean flag) throws Exception{
        System.out.println("已进入api接口------");
        System.out.println(flag);
        if(flag){
            String sql_res = "";
            JdbcTemplate jdbcTemplate = dataSourceConfig.jdbcTemplate(dataSourceConfig.dataSource());
            String sql = "select * from t_sys_dict_catg";
            List<Map<String, Object>> list_map = jdbcTemplate.queryForList(sql);
            for (Map<String, Object> map : list_map) {
                String id = map.get("id").toString();
                String remark = map.get("remark").toString();
                String row_str = String.format("Id: %s, Remark: %s", id, remark);
                sql_res = String.format("%s    %s", sql_res, row_str);
            }
            return ResultUtil.success(String.format("返回成功数据: %s!", sql_res));
        }

        return ResultUtil.error("抱歉sorry!");
    }

}