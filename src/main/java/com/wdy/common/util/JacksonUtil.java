package com.wdy.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wdy.common.config.JacksonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @desc Jackson工具类
 * @date 2019/5/24
 * @author wjy
 */
@Component
public class JacksonUtil {

    private static ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private JacksonConfig config;

    public ObjectMapper getObjectMapper() {
        return config.getObjectMapper(mapper);
    }

    /**
     * @desc String转Entity
     * @date 2019/5/24
     * @author wjy
     */
    public <T> T toEntity(String content, Class<T> valueType) {
        try {
            return getObjectMapper().readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @desc Object转String
     * @date 2019/5/24
     * @author wjy
     */
    public String toString(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
