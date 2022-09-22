package com.vilsale.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.vilsale.login.entity.User;
import com.vilsale.login.mapper.UserMapper;
import com.vilsale.login.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Log4j2
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void register(User user) {
        log.warn("register" + user.toString());
        this.save(user);


    }

    @Override
    public void login(User user) {
        log.warn("login:{}", user);
        MessageBuilder<User> messageBuilder = MessageBuilder.withPayload(user);
        messageBuilder.setHeader(RocketMQHeaders.KEYS, user.getUserName());
        Message<User> build = messageBuilder.build();

        rocketMQTemplate.send("LoginTopic", build);
    }

    @Override
    public JSONObject auth0(String phone, String password) {
        return null;
    }
}
