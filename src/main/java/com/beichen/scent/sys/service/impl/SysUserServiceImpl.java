package com.beichen.scent.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beichen.scent.common.CommonResponse;
import com.beichen.scent.common.enums.ExceptionCode;
import com.beichen.scent.common.exception.CommonException;
import com.beichen.scent.sys.dto.AllotRolesDto;
import com.beichen.scent.sys.dto.LoginDto;
import com.beichen.scent.sys.dto.RegisterDto;
import com.beichen.scent.sys.entity.SysUser;
import com.beichen.scent.sys.mapper.SysUserMapper;
import com.beichen.scent.sys.service.ISysUserRoleService;
import com.beichen.scent.sys.service.ISysUserService;
import com.beichen.scent.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ISysUserRoleService sysUserRoleService;

    /**
     * @return com.beichen.scent.common.CommonResponse
     * @Author fubiao
     * @Description 用户注册
     * @Date 10:39 2020/1/9
     * @Param [registerDto]
     **/
    @Transactional
    @Override
    public CommonResponse register(RegisterDto registerDto) {
        //判断是否有重复的用户名
        SysUser res = getOne(new QueryWrapper<SysUser>().eq("user_name", registerDto.getUserName()));
        if (res != null) {
            throw new CommonException(ExceptionCode.EXCEPTION_CODE_FAIL.getCode(), "用户名重复！");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(registerDto, sysUser);
        //对密码进行MD5加密
        sysUser.setPassword(DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes()));
        save(sysUser);
        return new CommonResponse().success();
    }


    /**
     * @return com.beichen.scent.common.CommonResponse
     * @Author fubiao
     * @Description 用户登录
     * @Date 16:34 2020/1/10
     * @Param [loginDto]
     **/
    @Override
    public SysUser login(LoginDto loginDto) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        //判断用户名是否存在
        wrapper.eq("user_name", loginDto.getUserName());
        SysUser user = getOne(wrapper);
        if (user == null) {
            throw new CommonException(ExceptionCode.EXCEPTION_CODE_FAIL.getCode(), "用户名不存在！");
        }
        //对密码进行MD5加密后对比
        wrapper.eq("password", DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes()));
        user = getOne(wrapper);
        if (user == null) {
            throw new CommonException(ExceptionCode.EXCEPTION_CODE_FAIL.getCode(), "密码错误！");
        }
        return user;
    }

    /**
     * @return com.beichen.scent.common.CommonResponse
     * @Author fubiao
     * @Description 分配角色
     * @Date 17:59 2020/7/3
     * @Param [allotRolesDto, sysUser]
     **/

}
