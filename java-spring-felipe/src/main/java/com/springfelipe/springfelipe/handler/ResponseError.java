package com.springfelipe.springfelipe.handler;

import java.util.Date;

public class ResponseError {

    private Date timestamp = new Date();
    private String status = "error";
    private int statusCode = 400;
    private String error;
}
