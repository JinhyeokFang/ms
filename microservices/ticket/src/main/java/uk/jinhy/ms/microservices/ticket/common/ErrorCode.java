package uk.jinhy.ms.microservices.ticket.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.jinhy.ms.api.exceptions.NotFoundException;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    BAD_PARAMETER_CONDITION("TICKET_400_01", "잘못된 파라미터 조건입니다.") {
        @Override
        public RuntimeException throwException() {
            return new NotFoundException(getErrorCode(), getErrorMessage());
        }
    },
    TICKET_NOT_FOUND("TICKET_404_01", "티켓을 찾을 수 없습니다.") {
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
