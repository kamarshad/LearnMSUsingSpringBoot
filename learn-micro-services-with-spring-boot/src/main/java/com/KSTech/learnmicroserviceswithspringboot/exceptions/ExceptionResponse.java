package com.KSTech.learnmicroserviceswithspringboot.exceptions;

import lombok.Getter;

import java.util.Date;

@Getter

public class ExceptionResponse {
    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(String message, Date timeStamp, String details) {
        super();
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }
}
