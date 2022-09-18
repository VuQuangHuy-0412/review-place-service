package com.example.reviewplaceservice.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private Integer httpStatus;
    private String code;
    private String message;
    private String traceId;
    private Boolean success = false;
}
