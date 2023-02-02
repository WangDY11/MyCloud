package com.wdy.login.entity;

import com.wdy.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author AMK-SYZ
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("bd_user")
@ApiModel(value="User对象", description="")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private String userId;

    @TableField("user_name")
    private String userName;

    @TableField("phone")
    private String phone;

    @TableField("password")
    private String password;

    @TableField(value = "ts", fill = FieldFill.INSERT_UPDATE)
    private String ts;

    @TableField(value = "version", fill = FieldFill.INSERT)
    @Version
    private Integer version;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private String createTime;


    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String PHONE = "phone";

    public static final String PASSWORD = "password";

    public static final String TS = "ts";

    public static final String VERSION = "version";

    public static final String CREATE_TIME = "create_time";

}
