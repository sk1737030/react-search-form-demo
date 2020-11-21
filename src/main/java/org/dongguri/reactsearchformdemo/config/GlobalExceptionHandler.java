package org.dongguri.reactsearchformdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.dongguri.reactsearchformdemo.config.error.BusinessException;
import org.dongguri.reactsearchformdemo.config.error.ErrorCode;
import org.dongguri.reactsearchformdemo.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    protected ResponseEntity<ErrorResponseDto> handleBusinessException(final BusinessException e) {
        log.error("BusinessException Occur: ", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponseDto errorResponseDto = new ErrorResponseDto(errorCode);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.valueOf(errorCode.getStatus()));
    }
}

