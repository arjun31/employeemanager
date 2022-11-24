package com.assessment.EmployeeManager.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String msg;
    private String details;

    public ErrorDetails(LocalDateTime localDateTime,String msg,String details){
        super();
        this.localDateTime=localDateTime;
        this.msg=msg;
        this.details=details;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMsg() {
        return msg;
    }

    public String getDetails() {
        return details;
    }
}
