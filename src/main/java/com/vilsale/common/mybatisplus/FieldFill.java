package com.vilsale.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.vilsale.common.util.DateUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @desc 公共字段自动填充，新增和修改时自动设置，实体类中字段注解@TableField(value = "ts", fill = FieldFill.INSERT_UPDATE)
 * @date 2019/5/24
 * @author wjy
 */
@Component
public class FieldFill implements MetaObjectHandler {

    @Autowired
    private DateUtil dateUtil;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("version", 0, metaObject);
        this.setInsertFieldValByName("ts", dateUtil.getTime(), metaObject);
        this.setInsertFieldValByName("create_time", dateUtil.getTime(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setInsertFieldValByName("ts", dateUtil.getTime(), metaObject);
    }

}
