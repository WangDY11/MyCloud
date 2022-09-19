package com.vilsale.rmq.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年09月19日
 */
@Data
public class CanalBinLogBean<T> implements Serializable {
    /**
     * binlog操作后数据
     */
    public JSONArray data;

    /**
     * 数据库名
     */
    private String database;

    private long es;

    /**
     *
     */
    private int id;

    /**
     * 是否是DDL语句
     */
    private boolean isDdl;


    /**
     * 表结构的字段类型
     */
    private JSONObject mysqlType;

    /**
     * UPDATE语句，旧数据
     */
    private JSONArray old;

    /**
     * 主键名称
     */
    private List<String> pkNames;

    /**
     * sql语句
     */
    private String sql;

    private JSONObject sqlType;

    /**
     * 表名
     */
    private String table;

    private long ts;

    /**
     * (新增)INSERT、(更新)UPDATE、(删除)DELETE、(删除表)ERASE等等
     */
    private String type;


}

