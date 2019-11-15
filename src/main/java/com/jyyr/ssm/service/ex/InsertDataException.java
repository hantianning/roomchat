package com.jyyr.ssm.service.ex;

/**
 * 插入数据失败
 */
public class InsertDataException extends ServiceException{

    private static final long serialVersionUID = 5792151958193953504L;

    public InsertDataException() {
        super();
    }

    public InsertDataException(String message) {
        super(message);
    }

    public InsertDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertDataException(Throwable cause) {
        super(cause);
    }

    protected InsertDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
