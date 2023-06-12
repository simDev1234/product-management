package com.notagkorea.productManagment.global.exception.handler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.notagkorea.productManagment.global.exception.GeneralException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ExceptionResponse {

    private static final long serialVersionUID = 1L;
    private int status;
    private String reasonOfError;
    private String errorMessage;

    public static ExceptionResponse fromException(GeneralException e) {
        return ExceptionResponse.builder()
                .status(e.getHttpStatus().value())
                .reasonOfError(e.getHttpStatus().getReasonPhrase())
                .errorMessage(e.getMessage())
                .build();
    }

}
