package com.vilsale.common.resttemplet;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @desc RestTemplate异常处理
 * @date 2019/5/27
 * @author wjy
 */
@Component
public class RestTemplateExceptionHandle{

    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (response.getRawStatusCode() == 200) {
            return false;
        } else {
            return true;
        }
    }


}
