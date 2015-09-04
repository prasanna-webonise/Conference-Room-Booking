package com.webonise.conferenceRoomBooking.exception;

public class CacheServiceException extends RuntimeException {
    
    private static final long serialVersionUID = 4829145006527269000L;

    public CacheServiceException(String message) {
        super(message);
    }

    public CacheServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CacheServiceException(Throwable throwable) {
        super(throwable);
    }
}
