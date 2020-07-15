package com.beichen.scent.common.exception;

import lombok.Data;

/**
 * @ClassName CommonException
 * @Description 项目通用异常
 * @Author fubiao
 * @Date 2020/1/8 16:13
 */
@Data
public class CommonException extends RuntimeException{

    private String msg;

    private Integer code;

    public CommonException(Integer code,String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CommonException(String msg) {
        super();
        this.msg = msg;
    }
}
