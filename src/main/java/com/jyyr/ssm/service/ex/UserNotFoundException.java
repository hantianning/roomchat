package com.jyyr.ssm.service.ex;

/**
 * 尝试访问用户数据不存在
 */
public class UserNotFoundException extends ServiceException{

    private static final long serialVersionUID = -3442726810336279061L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
