package com.beichen.scent.sys.service;

import com.beichen.scent.common.CommonResponse;
import com.beichen.scent.sys.dto.AddRoleDto;
import com.beichen.scent.sys.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.beichen.scent.sys.entity.SysUser;

/**
 * <p>
 * 系统角色表 服务类
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * @Author fubiao
     * @Description 添加角色
     * @Date 18:03 2020/7/2
     * @Param [addRoleDto]
     * @return com.beichen.scent.common.CommonResponse
     **/
    CommonResponse addRole(AddRoleDto addRoleDto, SysUser sysUser);

    /**
     * @Author fubiao
     * @Description 获取所有角色
     * @Date 11:56 2020/7/6
     * @Param [userId]
     * @return com.beichen.scent.common.CommonResponse
     **/
    CommonResponse getAll();

}
