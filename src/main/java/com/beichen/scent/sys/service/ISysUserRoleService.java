package com.beichen.scent.sys.service;

import com.beichen.scent.sys.dto.AllotRolesDto;
import com.beichen.scent.sys.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色关系中间表 服务类
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * @return java.lang.Boolean
     * @Author fubiao
     * @Description 分配角色
     * @Date 17:47 2020/7/3
     * @Param [sysUserRoles]
     **/
    List<Integer> allotRoles(AllotRolesDto allotRolesDto, Integer userId);

}
