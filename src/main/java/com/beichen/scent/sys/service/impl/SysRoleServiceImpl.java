package com.beichen.scent.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beichen.scent.common.CommonResponse;
import com.beichen.scent.common.enums.ExceptionCode;
import com.beichen.scent.common.exception.CommonException;
import com.beichen.scent.sys.dto.AddRoleDto;
import com.beichen.scent.sys.entity.SysRole;
import com.beichen.scent.sys.entity.SysUser;
import com.beichen.scent.sys.mapper.SysRoleMapper;
import com.beichen.scent.sys.service.ISysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {



    /**
     * @Author fubiao
     * @Description 添加角色
     * @Date 18:05 2020/7/2
     * @Param [addRoleDto]
     * @return com.beichen.scent.common.CommonResponse
     **/
    @Transactional
    @Override
    public CommonResponse addRole(AddRoleDto addRoleDto, SysUser sysUser) {
        SysRole sysRole = null;
        //判断角色名称是否重复
        sysRole = getOne(new QueryWrapper<SysRole>().eq("name",addRoleDto.getName()));
        if (sysRole != null) {
            throw new CommonException(ExceptionCode.EXCEPTION_CODE_FAIL.getCode(), "角色名称重复！");
        }
        //判断角色字符重复
        sysRole = getOne(new QueryWrapper<SysRole>().eq("role_character",addRoleDto.getRoleCharacter()));
        if (sysRole != null) {
            throw new CommonException(ExceptionCode.EXCEPTION_CODE_FAIL.getCode(), "角色字符重复！");
        }
        //保存到数据库
        sysRole = new SysRole();
        BeanUtils.copyProperties(addRoleDto, sysRole);
        sysRole.setCreateBy(sysUser.getId());
        sysRole.setUpdateBy(sysUser.getId());
        save(sysRole);
        return new CommonResponse().success();
    }

    /**
     * @Author fubiao
     * @Description 获取所有角色
     * @Date 11:58 2020/7/6
     * @Param []
     * @return com.beichen.scent.common.CommonResponse
     **/
    @Override
    public CommonResponse getAll() {
        List<SysRole> result = list();
        return new CommonResponse().success("获取成功！",result);
    }
}
