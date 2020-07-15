package com.beichen.scent.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName RegisterDto
 * @Description 注册用户传入对象
 * @Author fubiao
 * @Date 2020/1/8 19:28
 */
@Data
public class RegisterDto {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "手机号不能为空")
    private String mobile;

    @NotBlank(message = "姓名不能为空")
    private String realName;

    private String email;

    private Integer sex;

    private String address;

}
