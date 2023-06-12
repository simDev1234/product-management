package com.notagkorea.productManagment.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RequestBodyMalFormedException extends GeneralException{

    public RequestBodyMalFormedException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
