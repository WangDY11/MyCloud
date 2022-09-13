package com.vilsale.common.resttemplet;

import com.vilsale.common.auth.Auth;
import com.vilsale.common.environment.ThreadLocalEnv;
import com.vilsale.common.environment.ThreadLocalVar;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @desc RestTemplate拦截：使用RestTemplate发送的请求全部添加安全校验的请求头
 * @date 2019/5/27
 * @author wjy
 */
@Component
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    @Resource
    private Auth auth;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] bs, ClientHttpRequestExecution execution)
            throws IOException {
        ThreadLocalVar var = ThreadLocalEnv.getENV();
        HttpHeaders headers = request.getHeaders();
        if (var != null){
            headers.add("E-userId", var.getUserId());
            headers.add("E-userName", var.getUserName());
            headers.add("E-corpId", var.getCorpId());
            headers.add("E-corpCode", var.getCorpCode());
            headers.add("E-token", var.getToken());
        }
        ClientHttpResponse response = execution.execute(request, bs);
        return response;
    }

}
