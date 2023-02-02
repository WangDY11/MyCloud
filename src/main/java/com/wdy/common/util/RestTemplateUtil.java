package com.wdy.common.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc RestTemplate工具类（安全校验的请求头在RestTemplateInterceptor拦截中添加）
 * @date 2019/5/24
 * @author wjy
 */
@Log4j2
@Component
public class RestTemplateUtil {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JacksonUtil jacksonUtil;

    @Resource
    private JedisUtil jedisUtil;

    @Autowired
    private PropertiesUtil propertiesUtil;

    /**
     * @desc get请求
     * @param url 请求路径
     * @param responseType 返回值类型
     * @return
     * @date 2019/5/28
     * @author wjy
     */
    public <T> T get(String url, Class<T> responseType) {
        log.info(url);
        T t = restTemplate.getForObject(url, responseType);
        log.info(t.toString());
        return t;
    }

    /**
     * @desc post请求
     * @param url 请求路径
     * @param body 请求体
     * @param responseType 返回值类型
     * @return
     * @date 2019/5/28
     * @author wjy
     */
    public <T> T post(String url, Object body, Class<T> responseType) {
        log.info(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(jacksonUtil.toString(body), headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
        T t = responseEntity.getBody();
        log.info(t.toString());
        return t;
    }

    /**
     * @desc 包含额外请求头的get请求
     * @param url 请求路径
     * @param mapHeaders 额外的请求头
     * @param responseType 返回值类型
     * @return
     * @date 2019/5/28
     * @author wjy
     */
    public <T> T getWithHeader(String url, Map<String, String> mapHeaders, Class<T> responseType) {
        log.info(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(mapHeaders);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
        T t = responseEntity.getBody();
        log.info(t.toString());
        return t;
    }

    /**
     * @desc 包含额外请求头的post请求
     * @param url 请求路径
     * @param mapHeaders 额外的请求头
     * @param body 请求体
     * @param responseType 返回值类型
     * @return
     * @date 2019/5/28
     * @author wjy
     */
    public <T> T postWithHeader(String url, Map<String, String> mapHeaders, Object body, Class<T> responseType) {
        log.info(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setAll(mapHeaders);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(jacksonUtil.toString(body), headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
        T t = responseEntity.getBody();
        log.info(t.toString());
        return t;
    }


    public <T> T postAuth(String url, Object body, String api_key, String authorization, Class<T> responseType) {
        log.info(url);
        JSONObject ret = new JSONObject();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cm-api-key", api_key);
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Bearer " + authorization);
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (body == null) {
            body = new HashMap<>();
        }
        HttpEntity<String> entity = new HttpEntity<String>(jacksonUtil.toString(body), headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
        T t = responseEntity.getBody();
        ret.put("code", responseEntity.getStatusCode());
        ret.put("message", t.toString());
        log.info(t);
        return t;
    }

}
