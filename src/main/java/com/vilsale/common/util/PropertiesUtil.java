package com.vilsale.common.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @desc 读取配置文件
 * @date 2019/5/24
 * @author wjy
 */
@Component
public class PropertiesUtil implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * @desc 配置文件中，根据key获取value
     * @param key 配置键名称
     * @param c 配置值类型
     * @return
     * @date 2019/5/28
     * @author wjy
     */
    public <T> T getProperty(String key, Class<T> c) {
        return environment.getProperty(key, c);
    }

    /**
     * @desc 配置文件中，根据key获取value，获取不到返回默认值
     * @param key 配置键名称
     * @param c 配置值类型
     * @param t 配置默认值
     * @return
     * @date 2019/5/28
     * @author wjy
     */
    public <T> T getProperty(String key, Class<T> c, T t) {
        return environment.getProperty(key, c, t);
    }

}
