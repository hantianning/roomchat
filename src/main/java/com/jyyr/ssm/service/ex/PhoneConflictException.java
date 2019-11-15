package com.jyyr.ssm.service.ex;

public class PhoneConflictException extends ServiceException {
    private static final long serialVersionUID = -8383884093494706846L;

    public PhoneConflictException() {
        super();
    }

    public PhoneConflictException(String message) {
        super(message);
    }

    public PhoneConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneConflictException(Throwable cause) {
        super(cause);
    }

    protected PhoneConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
