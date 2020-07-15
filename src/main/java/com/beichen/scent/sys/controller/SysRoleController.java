package com.beichen.scent.sys.controller;


import com.beichen.scent.common.CommonResponse;
import com.beichen.scent.common.annotation.LoginUser;
import com.beichen.scent.sys.dto.AddRoleDto;
import com.beichen.scent.sys.entity.SysUser;
import com.beichen.scent.sys.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author fubiao
 * @since 2020-07-02
 */
@Api(tags = "系统角色相关接口")
@RestController
@RequestMapping("/sys/sysRole")
public class SysRoleController {

    @Autowired
    ISysRoleService sysRoleService;

    /**
     * @Author fubiao
     * @Description 添加角色
     * @Date 15:06 2020/7/6
     * @Param [sysUser, addRoleDto]
     * @return com.beichen.scent.common.CommonResponse
     **/
    @ApiOperation(value = "添加角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "角色名称", required = true, paramType = "String"),
            @ApiImplicitParam(name = "roleCharacter", value = "权限字符", required = true, paramType = "String"),
            @ApiImplicitParam(name = "state", value = "状态  0：禁用，1：正常", required = true, paramType = "Boolean"),
    })
    @PostMapping(value = "/add")
    @ResponseBody
    public CommonResponse addRole(@LoginUser SysUser sysUser, @RequestBody @Validated AddRoleDto addRoleDto) {
        return sysRoleService.addRole(addRoleDto,sysUser);
    }

    /**
     * @Author fubiao
     * @Description 获取所有角色列表
     * @Date 15:07 2020/7/6
     * @Param []
     * @return com.beichen.scent.common.CommonResponse
     **/
    @ApiOperation(value = "获取所有角色")
    @GetMapping(value = "/getAll")
    @ResponseBody
    public CommonResponse getAll() {
        return sysRoleService.getAll();
    }
}
