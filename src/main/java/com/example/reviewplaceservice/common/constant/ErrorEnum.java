package com.example.reviewplaceservice.common.constant;

public enum ErrorEnum {

    INVALID_INPUT_COMMON(400, "invalid_input_common", "%s");

    private final Integer httpStatus;
    private final String code;
    private final String message;

    ErrorEnum(Integer httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
