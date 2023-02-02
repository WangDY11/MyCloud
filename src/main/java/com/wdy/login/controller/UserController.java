package com.wdy.login.controller;


import com.alibaba.fastjson.JSONObject;
import com.wdy.common.response.ResponseBuilder;
import com.wdy.login.entity.User;
import com.wdy.login.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wdy.common.base.BaseController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/login/user")
public class UserController extends BaseController {
    @Resource(name = "userServiceImpl")
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        userService.login(user);
        return ResponseBuilder.success("登录成功");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        userService.register(user);
        return ResponseBuilder.success("注册成功");
    }

    @GetMapping ("/auth")
    public ResponseEntity auth(@RequestParam(value = "phone") String phone,
                               @RequestParam(value = "password")String password){
        JSONObject jsonObject = userService.auth0(phone, password);
        return ResponseBuilder.success(jsonObject);
    }
}
