package com.wdy.common.environment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 定义线程变量
 * @date 2019/5/24
 * @author wjy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadLocalVar {

    private String userId;
    private String userName;
    private String corpId;
    private String corpCode;
    private String token;

    public ThreadLocalVar(String userId, String userName, String corpId, String corpCode, String token) {
        this.userId = userId;
        this.userName = userName;
        this.corpId = corpId;
        this.corpCode = corpCode;
        this.token = token;
    }

    // 用于处理rocketmq事务消息异常
    private Exception e;

}
