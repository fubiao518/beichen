package com.beichen.scent.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @ClassName CommonResponse
 * @Description 通用返回结果
 * @Author fubiao
 * @Date 2020/1/8 17:26
 */
@ApiModel(description = "通用返回对象")
@Data
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 返回状态码
     */
    @ApiModelProperty(value = "返回状态码 200成功 -1失败")
    private Integer code;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息")
    private String msg;
    /**
     * 返回的数据
     */
    @ApiModelProperty(value = "返回的数据对象")
    private Object data;

    private CommonResponse result(int code) {
        this.code = code;
        this.msg = "";
        this.data = "";
        return this;
    }

    private CommonResponse result(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = "";
        return this;
    }

    private CommonResponse result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    /****************************成功************************************/

    public  CommonResponse success() {
        return result(200, "操作成功！");
    }

    public CommonResponse success(@NonNull String msg) {
        return result(200, msg);
    }

    public CommonResponse success(@NonNull String msg, Object data) {
        return result(200, msg,data);
    }


    /****************************失败************************************/

    public CommonResponse fail() {
        return result(-1, "操作失败！");
    }

    public CommonResponse fail(@NonNull String msg) {
        return result(-1, msg);
    }

    public CommonResponse fail(int code, @NonNull String msg) {
        return result(code, msg);
    }

    public CommonResponse fail(@NonNull String msg, Object data) {
        return result(-1, msg, data);
    }
}
