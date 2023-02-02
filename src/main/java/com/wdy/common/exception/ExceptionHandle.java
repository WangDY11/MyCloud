package com.wdy.common.exception;

import com.wdy.common.response.ResponseBuilder;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

/**
 * @desc 统一异常处理
 * @date 2020-09-10
 * @author wqq
 */
@Log4j2
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handler(Exception e) {
        if (e.getMessage() != null && e.getMessage().contains("Duplicate entry")) {
            log.warn(e.getMessage(),e);
            return ResponseBuilder.error(211,"请勿重复提交");
        } else if (e instanceof BusinessException) {
            log.warn(e.getMessage(),e);
            return ResponseBuilder.error(501,"【501】"+e.getMessage());
        } else if (e instanceof NullPointerException) {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(502, "【502】系统处理出现异常，请联系服务商处理！");
        } else if (e instanceof IndexOutOfBoundsException) {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(503, "【503】系统处理出现异常，请联系服务商处理！");
        } else if (e instanceof IllegalAccessException) {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(504, "【504】系统处理出现异常，请联系服务商处理！");
        } else if (e instanceof ArrayIndexOutOfBoundsException) {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(505, "【505】系统处理出现异常，请联系服务商处理！");
        } else if (e instanceof ClassNotFoundException) {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(506, "【506】系统处理出现异常，请联系服务商处理！");
        } else if (e instanceof AccessDeniedException) {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(507, "【507】系统处理出现异常，请联系服务商处理！");
        }else if (e instanceof SQLException) {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(508, "【508】系统处理出现异常，请联系服务商处理！");
        }else {
            // 打印异常到日志
            log.error(e.getMessage(),e);
            return ResponseBuilder.error(e);
        }
    }

}
