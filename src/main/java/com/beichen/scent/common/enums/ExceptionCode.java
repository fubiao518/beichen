package com.beichen.scent.common.enums;

/**
 * 异常枚举
 */
public enum ExceptionCode {

    EXCEPTION_CODE_SUCCESS(200, "操作成功！"),
    EXCEPTION_CODE_FAIL(-1, "操作失败！");

    private String msg;

    private Integer code;

    ExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }}
