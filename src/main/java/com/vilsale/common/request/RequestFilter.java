package com.vilsale.common.request;

import com.vilsale.common.environment.ThreadLocalEnv;
import com.vilsale.common.environment.ThreadLocalVar;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @desc 安全验证
 * @date 2019/5/24
 * @author wjy
 */
@Log4j2
@Component
@Aspect
public class RequestFilter {


    /**
     * @desc com.vilsale包下全部方法
     * @date 2019/5/24
     * @author wjy
     */
    @Pointcut(value = "execution(* com.vilsale..*.*(..))")
    public void validatePackage() {
    }

    /**
     * @desc 使用@Controller注解的方法
     * @date 2019/5/24
     * @author wjy
     */
    @Pointcut(value = "within(@org.springframework.stereotype.Controller *)")
    public void validateController() {
    }

    /**
     * @desc 使用@RestController注解的方法
     * @date 2019/5/24
     * @author wjy
     */
    @Pointcut(value = "within(@org.springframework.web.bind.annotation.RestController *)")
    public void validateRestController() {
    }

    /**
     * @desc com.vilsale包下使用@Controller注解和@RestController注解的全部方法
     * @date 2019/5/24
     * @author wjy
     */
    @Pointcut(value = "validatePackage()&&(validateController()||validateRestController())")
    public void validate() {
    }

    @Around(value = "validate()")
    public Object doLoginValidate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String userId = request.getHeader("E-userId");
        String userName = request.getHeader("E-userName");
        String corpId = request.getHeader("E-corpId");
        String corpCode = request.getHeader("E-corpCode");
        String token = request.getHeader("E-token");

        // 设置线程变量
        ThreadLocalVar threadLocalVar = new ThreadLocalVar(userId, userName, corpId, corpCode, token);
        ThreadLocalEnv.setENV(threadLocalVar);

        // 记录日志
        Signature signature = proceedingJoinPoint.getSignature();
        log.info("IP: {}, Port: {}, URI: {}, Method: {}", request.getRemoteAddr(), request.getServerPort(),
                request.getRequestURI(), request.getMethod());
        log.info("Class: {}, Method: {}, Args: {}", signature.getDeclaringTypeName(), signature.getName(),
                Arrays.toString(proceedingJoinPoint.getArgs()));

        return proceedingJoinPoint.proceed();

    }
}
