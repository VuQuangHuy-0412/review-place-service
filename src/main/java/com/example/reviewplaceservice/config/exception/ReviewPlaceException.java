package com.example.reviewplaceservice.config.exception;

import com.example.reviewplaceservice.common.constant.ErrorEnum;
import com.example.reviewplaceservice.common.model.ErrorResponse;
import lombok.Data;
import org.slf4j.MDC;

@Data
public class ReviewPlaceException extends RuntimeException {
    private boolean isInternal; // Exception fired within current service or not
    private Integer httpStatus;
    private String errorCode;

    public ReviewPlaceException(ErrorEnum errorEnum, String... args) {
        super(String.format(errorEnum.getMessage(), args));
        this.httpStatus = errorEnum.getHttpStatus();
        this.errorCode = errorEnum.getCode();
    }

    public ReviewPlaceException(int httpStatus, String errorCode, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public ReviewPlaceException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.isInternal = false;
        this.httpStatus = errorResponse.getHttpStatus();
        this.errorCode = errorResponse.getCode();
    }

    public ReviewPlaceException(String msg) {
        this(ErrorEnum.INVALID_INPUT_COMMON, msg);
    }

    public boolean isErrorEnum(ErrorEnum errorEnum) {
        return errorEnum.getCode().equals(this.errorCode);
    }

    public ErrorResponse convertToErrorResponse() {
        ErrorResponse ret = new ErrorResponse();
        ret.setHttpStatus(this.httpStatus);
        ret.setCode(this.errorCode);
        ret.setMessage(this.getMessage());
        ret.setTraceId(MDC.get("traceId"));
        return ret;
    }
}
