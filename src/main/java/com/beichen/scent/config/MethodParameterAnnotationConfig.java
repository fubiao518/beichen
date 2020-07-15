package com.beichen.scent.config;

import com.beichen.scent.common.annotation.SysUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @ClassName MethodParameterAnnotationConfig
 * @Description
 * @Author fubiao
 * @Date 2020/7/3 15:24
 */
@Configuration
public class MethodParameterAnnotationConfig implements WebMvcConfigurer {
    @Autowired
    SysUserMethodArgumentResolver sysUserMethodArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(sysUserMethodArgumentResolver);
    }

}
