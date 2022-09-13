package com.vilsale.login.controller;

import com.vilsale.login.service.VilsaleLoginService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wdy
 * @Description web端登录
 * @createTime 2022年08月10日
 */
@Controller
@RequestMapping("/login/webLogin")
@Log4j2
@Api(tags = "乡村销客web端登录注册服务")
public class WebLoginController {

    @Resource(name = "vilsaleLoginServiceImpl")
    private VilsaleLoginService vilsaleLoginService;
    @Resource
    private HttpServletRequest request;









    @GetMapping("/test")
    public void test(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("http://www.vilsale.com/marking/#/app-store");
    }

    @GetMapping("/test1")
    public String test1() throws IOException {
        return  "redirect:http://www.vilsale.com/marking/#/app-store";
    }

    @GetMapping("/test2")
    public ModelAndView test2(HttpServletResponse resp) throws IOException {
        return new ModelAndView("redirect:http://www.baidu.com");
    }




}
