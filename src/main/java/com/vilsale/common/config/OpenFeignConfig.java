package com.vilsale.common.config;

import com.alibaba.fastjson.JSONObject;
import com.vilsale.common.exception.BusinessException;
import com.vilsale.common.interceptor.OpenFeignInterceptor;
import feign.FeignException;
import feign.Logger;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import io.netty.util.CharsetUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: wdy
 * @date: 2022/3/10
 */
@Configuration
@Log4j2
public class OpenFeignConfig {

    /**
     * 自定义feign拦截器
     * @return
     */
    @Bean
    public OpenFeignInterceptor openFeignInterceptor() {
        return new OpenFeignInterceptor();
    }

    /**
     * feign响应数据解析
     * @return
     */
    @Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter())){
            @Override
            public Object decode(Response response, Type type) throws IOException, FeignException {
                log.info("openfeign发起请求 - {}",response.request().url());
                Response.Body body = response.body();
                if (body == null){
                    log.error("feign请求异常responseBody为null - {} ", response.request().url());
                    throw new BusinessException("feign请求异常responseBody为null:" + response);
                }
                // String类型
                if (String.class.equals(type)){
                    return super.decode(response, type);
                }
                String result = Util.toString(body.asReader(CharsetUtil.UTF_8));
                // jsonObject类型
                if ( isJson(result) ) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    int code = jsonObject.containsKey("code") ? jsonObject.getInteger("code") : 500;
                    // 200 && 204
                    if (code != HttpStatus.OK.value() && code != HttpStatus.NO_CONTENT.value()){
                        log.error("feign请求异常code - {}, url - {}, message - {} ", code, response.request().url(), result);
                        String message = jsonObject.containsKey("message") ? jsonObject.getString("message") : "系统处理出现异常，请联系服务商处理！";
                        throw new RuntimeException(message);
                    }
                    return jsonObject;
                }
                throw new DecodeException(response.status(), "不支持数据" + type, response.request());
            }
        };
    }

    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new GateWayMappingJackson2HttpMessageConverter());
        return new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return httpMessageConverters;
            }
        };
    }

    public class GateWayMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
        GateWayMappingJackson2HttpMessageConverter(){
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
            setSupportedMediaTypes(mediaTypes);
        }
    }

    @Bean
    Logger.Level feignLoggerLeave(){
        return Logger.Level.FULL;
    }

    /**
     * 判断是否是json
     * @param content
     * @return
     */
    public static boolean isJson(String content) {
        if(StringUtils.isEmpty(content)){
            return false;
        }
        boolean isJsonObject = true;
        try {
            JSONObject.parseObject(content);
        } catch (Exception e) {
            isJsonObject = false;
        }
        return isJsonObject;
    }

}
