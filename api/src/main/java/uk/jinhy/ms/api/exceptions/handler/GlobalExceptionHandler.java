package uk.jinhy.ms.api.exceptions.handler;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uk.jinhy.ms.api.exceptions.BadRequestException;
import uk.jinhy.ms.api.exceptions.NotFoundException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody ErrorResponseDto handleNotFoundException(BadRequestException ex) {
        return new ErrorResponseDto(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody ErrorResponseDto handleNotFoundException(NotFoundException ex) {
        return new ErrorResponseDto(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody ErrorResponseDto handleUnexpectedException(RuntimeException ex) {
        return new ErrorResponseDto("UNEXPECTED_ERROR", ex.getMessage());
    }

    @Data
    public static class ErrorResponseDto {
        private final String errorCode;
        private final String errorMessage;
    }
}
