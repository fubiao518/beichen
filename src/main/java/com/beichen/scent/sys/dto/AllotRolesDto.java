package com.beichen.scent.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName AllotRolesDto
 * @Description 为用户分配角色传入对象
 * @Author fubiao
 * @Date 2020/7/3 17:42
 */
@Data
public class AllotRolesDto {

    /**
     * 角色id集合
     */
    private List<Integer> roleIds;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private Integer userId;




}
