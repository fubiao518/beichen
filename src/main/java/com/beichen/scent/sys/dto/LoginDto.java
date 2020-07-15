package com.beichen.scent.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName LoginDto
 * @Description 用户登录传入参数
 * @Author fubiao
 * @Date 2020/1/10 14:36
 */
@Data
public class LoginDto {
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;
}
