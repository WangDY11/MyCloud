package com.wdy.login.service;

import com.alibaba.fastjson.JSONObject;
import com.wdy.login.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AMK-SYZ
 * @since 2022-09-15
 */
public interface IUserService extends IService<User> {

    void register(User user);

    void login(User user);

    JSONObject auth0(String phone, String password);
}
