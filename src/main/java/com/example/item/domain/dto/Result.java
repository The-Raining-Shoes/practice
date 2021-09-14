package com.example.item.domain.dto;

import com.example.item.exception.ErrorCode;
import com.example.item.utils.JsonUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @author HXM
 * @date 2020年04月22日 9:28
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * 是否成功
     */
    private boolean success;

    /*
     * 编码
     */
    private String code;

    /*
     * 返回信息
     */
    private String msg;

    /*
     * 数据
     */
    private T data;

    public Result(T data) {
        this(ErrorCode.OK, data);
    }

    public Result(ErrorCode error, T data) {
        this.msg = error.getReason();
        this.code = error.getCode();
        this.data = data;
        if (error.equals(ErrorCode.OK)) {
            this.success = true;
        }
    }

    public String json() {
        return JsonUtil.toJson(this);
    }
}
