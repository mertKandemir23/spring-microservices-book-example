package com.kandemirmert.bookstore.exception;

public class BookHasNotRecordToTheSystemException extends RuntimeException{
    public BookHasNotRecordToTheSystemException() {
    }

    public BookHasNotRecordToTheSystemException(String message) {
        super(message);
    }

    public BookHasNotRecordToTheSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookHasNotRecordToTheSystemException(Throwable cause) {
        super(cause);
    }

    public BookHasNotRecordToTheSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
