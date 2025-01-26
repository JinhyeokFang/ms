package uk.jinhy.ms.api.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String errorCode;
    private final String message;

    public NotFoundException(String errorCode, String message) {
        super(errorCode + ":" + message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
