package com.karthik.github.demo.beans;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {
    // 0-> Success, -1 -> Failure
    private int status = 0;

    private String message="";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
