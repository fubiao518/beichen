package com.beichen.scent.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beichen.scent.common.enums.ExceptionCode;
import com.beichen.scent.common.exception.CommonException;
import com.beichen.scent.sys.dto.AllotRolesDto;
import com.beichen.scent.sys.entity.SysUser;
import com.beichen.scent.sys.entity.SysUserRole;
import com.beichen.scent.sys.mapper.SysUserRoleMapper;
import com.beichen.scent.sys.service.ISysUserRoleService;
import com.beichen.scent.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色关系中间表 服务实现类
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Autowired
    private ISysUserService sysUserService;
    /**
     * @Author fubiao
     * @Description 分配角色
     * @Date 17:36 2020/7/3
     * @Param [sysUserRoles]
     * @return java.lang.Boolean
     **/
    @Transactional
    @Override
    public List<Integer> allotRoles(AllotRolesDto allotRolesDto,Integer userId) {
        //判断分配的用户是否存在
        SysUser sysUser = sysUserService.getById(allotRolesDto.getUserId());
        if (sysUser == null) {
            throw new CommonException(ExceptionCode.EXCEPTION_CODE_FAIL.getCode(), "用户不存在！");
        }
        //传入角色id集合为空，删除当前用户全部角色
        if (allotRolesDto.getRoleIds().isEmpty()) {
            //删除全部角色
            remove(new QueryWrapper<SysUserRole>().eq("user_id", allotRolesDto.getUserId()));
            return new ArrayList<Integer>();
        }

        List<SysUserRole> list = new ArrayList<>();
        allotRolesDto.getRoleIds().forEach(item -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setCreateBy(userId);
            sysUserRole.setUpdateBy(userId);
            sysUserRole.setUserId(allotRolesDto.getUserId());
            sysUserRole.setRoleId(item);
            list.add(sysUserRole);
        });
        //删除全部角色
        remove(new QueryWrapper<SysUserRole>().eq("user_id", allotRolesDto.getUserId()));
        //添加角色
        saveBatch(list);
        //查询所有角色
        List<SysUserRole> result = list(new QueryWrapper<SysUserRole>().eq("user_id", allotRolesDto.getUserId()));
        return result.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
    }
}
