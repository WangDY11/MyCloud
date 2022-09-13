package com.vilsale.common.exception;

/**
 * @desc 业务异常
 * @date 2019/5/24
 * @author wjy
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

}
