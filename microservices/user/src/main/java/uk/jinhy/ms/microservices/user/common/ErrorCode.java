package uk.jinhy.ms.microservices.user.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.jinhy.ms.api.exceptions.NotFoundException;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    USER_NOT_FOUND("USER_404_01", "사용자를 찾을 수 없습니다.") {
        @Override
        public RuntimeException throwException() {
            return new NotFoundException(getErrorCode(), getErrorMessage());
        }
    }
    ;

    private final String errorCode;
    private final String errorMessage;

    public abstract RuntimeException throwException();
}
