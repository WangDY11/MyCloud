package com.vilsale.login.service.impl;

import com.vilsale.login.entity.User;
import com.vilsale.login.mapper.UserMapper;
import com.vilsale.login.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
