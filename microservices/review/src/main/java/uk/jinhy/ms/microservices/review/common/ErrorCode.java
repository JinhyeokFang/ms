package uk.jinhy.ms.microservices.review.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.jinhy.ms.api.exceptions.NotFoundException;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    REVIEW_NOT_FOUND("REVIEW_404_01", "리뷰를 찾을 수 없습니다.") {
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
