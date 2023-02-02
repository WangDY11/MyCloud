package com.wdy.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wdy.common.jackson.EntityModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @desc Jackson配置
 * @date 2019/5/24
 * @author wjy
 */
@Configuration
public class JacksonConfig {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private EntityModule module;

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder.createXmlMapper(false).build();
        return getObjectMapper(mapper);
    }

    public ObjectMapper getObjectMapper(ObjectMapper mapper) {
        SimpleModule simpleModule = new SimpleModule();
        mapper.registerModule(simpleModule);
        mapper.registerModule(module);
        // 空值不序列化
        // mapper.setSerializationInclusion(Include.NON_EMPTY);
        // 设置时间格式
        mapper.setDateFormat(FORMAT);
        // 设置时区
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return mapper;
    }

}
