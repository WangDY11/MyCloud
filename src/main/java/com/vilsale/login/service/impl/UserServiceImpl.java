package com.vilsale.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.vilsale.login.entity.User;
import com.vilsale.login.mapper.UserMapper;
import com.vilsale.login.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AMK-SYZ
 * @since 2022-09-15
 */
@Service
@Log4j2
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void register(User user) {
        log.warn("register" + user.toString());
        this.save(user);


    }

    @Override
    public void login(User user) {

    }

    @Override
    public JSONObject auth0(String phone, String password) {
        return null;
    }
}
