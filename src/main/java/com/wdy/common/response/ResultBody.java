package com.wdy.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回数据请求体
 * @author wqq
 * @date 2021-09-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBody<E> implements Serializable {

    /**
     * 序列化标识
     */
    private static final long serialVersionUID = 1L;

    /**
     *  状态码
     */
    private  int code;
    /**
     *  数据
     */
    private   E data;
    /**
     *  消息
     */
    private   String message;
    /**
     * 时间戳
     */
    private  Long  currentTime;


}
