package com.rfchina.internet.mytestapp.http.entity;


public class EntryWrapper {

    /**
     * status : 1001
     * message : 成功
     */

    private int status;
    private String message;

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

    public boolean isSuccess() {
        return  status == 200 || status == 1001;
    }
}
