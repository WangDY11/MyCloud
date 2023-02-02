package com.wdy.common.auth;

import com.auth0.jwt.JWTSigner;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
@Log4j2
public class Auth {
    @Value("${app_id}")
    private String appId;
    @Value("${user_verify_secret}")
    private String userVerifySecret;


    public String getTempToken() {
        Map<String, Object> map = new HashMap<>();
        long current = new Date().getTime() / 1000;
        long minus = 7 * 24 * 3600;
        map.put("type", "temp");
        map.put("iat", current);
        map.put("exp", current + minus);
        map.put("aud", appId);
        map.put("iss", "1");
        return new JWTSigner(userVerifySecret).sign(map);
    }

}
