package com.example.item.exception;

/**
 * @author HXM
 * @date 2020年04月22日 9:33
 */
public enum ErrorCode {
    OK("0", "成功"),
    USER_AUTHENTICATION_FAIL("10000", "用户名或者密码不正确");

    ErrorCode(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    private String code;
    private String reason;

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}
