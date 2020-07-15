package com.beichen.scent.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName AddRoleDto
 * @Description 添加角色传入对象
 * @Author fubiao
 * @Date 2020/7/2 17:55
 */
@Data
public class AddRoleDto {

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String name;

    /**
     * 权限字符
     */
    @NotBlank(message = "权限字符不能为空")
    private String roleCharacter;

    /**
     * 状态  0：禁用，1：正常
     */
    @NotNull(message = "请选择状态")
    private Boolean state;
}
