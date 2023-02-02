package com.wdy.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;


/**
 * @author wqq
 * @date 2021-06-22
 * 统一格式返回数据构建类
 */
@Data
@NoArgsConstructor
public class ResponseBuilder {

    /**
     * 默认返回值
     */
    private static String message;

    /**
     * 操作成功默认返回信息
     */
    private static final String  DEFUALT_SUCCESS_INFO = "操作成功";

    /**
     * 构建返回数据请求体
     * @param code   返回状态码
     * @param data   返回数据
     * @param message   返回信息
     * @param <E>     返回数据类型
     * @return      返回请求体
     */
    public static <E> ResultBody<E> body(int code, E data, String message){
        return new ResultBody<E>(code,data,message,Instant.now().toEpochMilli());
    }

    /**
     * 成功返回，单纯指定返回提示信息
     * @param message  返回数据
     * @param <E>   返回数据类型
     * @return      返回response
     */
    public static <E> ResponseEntity<ResultBody> success(String message) {
        return  new ResponseEntity<ResultBody>(body(HttpStatus.OK.value(), null ,message),HttpStatus.OK);
    }

    /**
     * 构建返回数据请求体
     * @param code      返回状态码
     * @param message   返回信息
     * @param <E>       返回数据类型
     * @return          请求体
     */
    public static <E> ResultBody<E> body(int code, String message){
        return new ResultBody<E>(code,null,message,Instant.now().toEpochMilli());
    }

    /**
     * 成功返回，不指定返回提示信息
     * @param data  返回数据
     * @param <E>   返回数据类型
     * @return      返回response
     */
    public static <E> ResponseEntity<ResultBody> success(E data) {
        return  new ResponseEntity<ResultBody>(body(HttpStatus.OK.value(),data,DEFUALT_SUCCESS_INFO),HttpStatus.OK);
    }

    /**
     * 接收数据和返回结果
     * @param data  返回数据
     * @param <E>   返回数据类型
     * @param message    返回信息
     * @return    返回response
     */
    public static <E> ResponseEntity<ResultBody> success(E data, String message) {
        return  new ResponseEntity<ResultBody>(body(HttpStatus.OK.value(),data,message),HttpStatus.OK);
    }

    /**
     * 指定成功编码
     * @param code  返回结果的请求编码
     * @param data  返回数据
     * @param <E>   返回数据类型
     * @param message  请求成功返回信息
     * @return   统一返回模板
     */
    public static <E> ResponseEntity<ResultBody> success(E data, String message, Integer code){
        return  new ResponseEntity<ResultBody>(body(code, data, message),HttpStatus.OK);
    }

    /**
     * 接收数据和返回结果
     * @return    返回response
     */
    public static <E> ResponseEntity<ResultBody> error(Exception e) {
        ResultBody<E> body = body(500, null, e.getMessage());
        return  new ResponseEntity<ResultBody>(body,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     *  根据报错信息和异常返回错误请求
     * @param messages    报错信息,如果不自定义则显示系统默认
     * @return   响应对象
     */
    public static <E> ResponseEntity<ResultBody> error(String messages) {
        ResultBody<E> body = body(500, null, messages);
        return new ResponseEntity<ResultBody>(body, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    /**
     * 指定返回值中的端口号和返回信息
     * @param code       返回端口号
     * @param messages
     * @param <E>
     * @return
     */
    public static <E> ResponseEntity<ResultBody> error(int code, String messages) {
        ResultBody<E> body = body(code, null, messages);
        return new ResponseEntity<ResultBody>(body, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    /**
     * 根据请求状态码返回请求信息
     * @param code
     * @param messages  报错信息,如果不自定义则显示系统默认
     * @return
     */
    public static <E> ResponseEntity<ResultBody> error(HttpStatus code, String messages) {
        ResultBody<E> body = body(code.value(), messages);
        return new ResponseEntity<ResultBody>(body, code);

    }


}
