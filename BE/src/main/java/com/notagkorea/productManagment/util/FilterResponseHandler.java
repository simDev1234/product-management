package com.notagkorea.productManagment.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notagkorea.productManagment.global.exception.GeneralException;
import com.notagkorea.productManagment.global.exception.handler.ExceptionResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class FilterResponseHandler {

    public static void sendFilterExceptionResponse(HttpServletResponse response,
        GeneralException e) throws IOException {

        response.setStatus(e.getHttpStatus().value());
        response.setContentType((APPLICATION_JSON_VALUE));
        response.setCharacterEncoding("utf-8");
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .status(e.getHttpStatus().value())
                .reasonOfError(e.getHttpStatus().getReasonPhrase())
                .errorMessage(e.getMessage())
                .build();
        new ObjectMapper().writeValue(response.getWriter(), exceptionResponse);

    }

    public static void sendSuccessResponse(HttpServletResponse response, String message)
        throws IOException {

        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", message);

        sendSuccessResponse(response, responseMap);
    }

    public static void sendSuccessResponse(HttpServletResponse response,
        Map<String, String> responseMap) throws IOException {

        new ObjectMapper().writeValue(response.getWriter(), responseMap);
    }

}
