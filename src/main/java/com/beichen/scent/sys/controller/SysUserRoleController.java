package com.beichen.scent.sys.controller;


import com.beichen.scent.common.CommonResponse;
import com.beichen.scent.common.annotation.LoginUser;
import com.beichen.scent.sys.dto.AllotRolesDto;
import com.beichen.scent.sys.entity.SysUser;
import com.beichen.scent.sys.service.ISysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户角色关系中间表 前端控制器
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
@Api(tags = "用户角色中间表controller")
@RestController
@RequestMapping("/sys/sysUserRole")
public class SysUserRoleController {

    @Autowired
    ISysUserRoleService sysUserRoleService;


    @ApiOperation(value = "分配角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleIds", value = "角色id集合", paramType = "List"),
            @ApiImplicitParam(name = "userId", value = "被分配角色的用户id", required = true, paramType = "Integer"),
    })
    @PostMapping("/allotRoles")
    @ResponseBody
    public CommonResponse allotRoles(@RequestBody @Validated AllotRolesDto allotRolesDto, @LoginUser SysUser sysUser) {
        List<Integer> result = sysUserRoleService.allotRoles(allotRolesDto, sysUser.getId());
        return new CommonResponse().success("操作成功！", result);
    }

}
