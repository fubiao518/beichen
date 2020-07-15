package com.beichen.scent.sys.service;

import com.beichen.scent.common.CommonResponse;
import com.beichen.scent.sys.dto.AllotRolesDto;
import com.beichen.scent.sys.dto.LoginDto;
import com.beichen.scent.sys.dto.RegisterDto;
import com.beichen.scent.sys.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
public interface ISysUserService extends IService<SysUser> {


    /**
     * @Author fubiao
     * @Description 用户注册
     * @Date 14:38 2020/1/10
     * @Param [registerDto]
     * @return com.beichen.scent.common.CommonResponse
     **/
    CommonResponse register(RegisterDto registerDto);

    /**
     * @Author fubiao
     * @Description 用户登录
     * @Date 14:39 2020/1/10
     * @Param [loginDto]
     * @return com.beichen.scent.common.CommonResponse
     **/
    SysUser login(LoginDto loginDto);

}
