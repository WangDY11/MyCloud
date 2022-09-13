package com.vilsale.common.interceptor;

import com.vilsale.common.auth.Auth;
import com.vilsale.common.environment.ThreadLocalEnv;
import com.vilsale.common.environment.ThreadLocalVar;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;

/**
 * @Description: openFeign拦截器
 * @author: wdy
 * @date: 2022/3/10 9:55
 */
public class OpenFeignInterceptor implements RequestInterceptor {
    @Resource
    private Auth auth;

    @Override
    public void apply(RequestTemplate template) {
        ThreadLocalVar var = ThreadLocalEnv.getENV();
        if (var != null){
            template.header("E-userId",var.getUserId());
            template.header("E-userName",var.getUserName());
            template.header("E-corpId", var.getCorpId());
            template.header("E-corpCode", var.getCorpCode());
            if (StringUtils.isNotEmpty(var.getToken())){
                template.header("E-token", var.getToken());
            } else {
//                template.header("E-token", auth.getTempToken());
            }

        } else {
//            template.header("E-token", auth.getTempToken());
        }

    }
}
