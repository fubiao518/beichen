package com.beichen.scent.common.annotation;

import com.beichen.scent.common.exception.CommonException;
import com.beichen.scent.sys.entity.SysUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * @Author fubiao
 * @Description 解析有@SysUser注解的参数
 * @Date 20:59 2020/1/10
 * @Param 
 * @return 
 **/
@Component
public class SysUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    
    /**
     * @Author fubiao
     * @Description 判断方法的参数是否有@LoginUser
     * @Date 20:59 2020/1/10
     * @Param [methodParameter]
     * @return boolean
     **/
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.hasParameterAnnotation(LoginUser.class)) {
            return true;
        }
        return false;
    }
    
    /**
     * @Author fubiao
     * @Description 方法的参数有@LoginUser
     * @Date 21:01 2020/1/10
     * @Param [methodParameter, modelAndViewContainer, nativeWebRequest, webDataBinderFactory]
     * @return java.lang.Object
     **/
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        LoginUser userAnnotation = methodParameter.getParameterAnnotation(LoginUser.class);
         SysUser user = (SysUser)nativeWebRequest.getAttribute(userAnnotation.value(),NativeWebRequest.SCOPE_SESSION);
        if (user == null) {
            throw new CommonException(-1, "登录超时，请重新登录！");
        }
        return user;
    }
}
