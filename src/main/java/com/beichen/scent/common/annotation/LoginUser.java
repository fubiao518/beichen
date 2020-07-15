package com.beichen.scent.common.annotation;


import com.beichen.scent.common.CommonConstant;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 获取当前登录用户注解
 */
@Target({ElementType.PARAMETER})//定义在参数上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {

    String value() default CommonConstant.LOGIN_USER;
}
