package com.beichen.scent.common;

import lombok.Data;

/**
 * @ClassName ExceptionResponse
 * @Description 统一异常信息返回
 * @Author fubiao
 * @Date 2020/1/9 15:40
 */
@Data
public class ExceptionResponse {

    private Integer code;

    private String msg;


    private String path;

    public ExceptionResponse(Integer code, String msg, String path) {
        this.code = code;
        this.msg = msg;
        this.path = path;
    }
}
