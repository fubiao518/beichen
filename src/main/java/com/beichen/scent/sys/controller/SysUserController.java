package com.beichen.scent.sys.controller;


import com.beichen.scent.common.CommonConstant;
import com.beichen.scent.common.CommonResponse;
import com.beichen.scent.sys.dto.LoginDto;
import com.beichen.scent.sys.dto.RegisterDto;
import com.beichen.scent.sys.entity.SysUser;
import com.beichen.scent.sys.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
@Api(tags = "系统用户相关接口")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * @return com.beichen.scent.common.CommonResponse
     * @Author fubiao
     * @Description 注册用户
     * @Date 17:10 2020/1/10
     * @Param [registerDto]
     **/
    @ApiOperation(value = "注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "String"),
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "String"),
            @ApiImplicitParam(name = "email", value = "邮箱", paramType = "String"),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, paramType = "Integer"),
            @ApiImplicitParam(name = "address", value = "住址", paramType = "String")
    })
    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResponse register(@RequestBody @Validated RegisterDto registerDto) {
        return sysUserService.register(registerDto);
    }

    /**
     * @return com.beichen.scent.common.CommonResponse
     * @Author fubiao
     * @Description 用户登录
     * @Date 17:17 2020/1/10
     * @Param [loginDto, session]
     **/
    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "String"),
    })
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResponse login(@RequestBody @Validated LoginDto loginDto, HttpSession session) {
        SysUser user = sysUserService.login(loginDto);
        session.setAttribute(CommonConstant.LOGIN_USER, user);
        return new CommonResponse().success("登录成功！", user);
    }

}
