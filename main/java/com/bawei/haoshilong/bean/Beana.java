package com.bawei.haoshilong.bean;

/*
 *@auther:郝世龙
 *@Date: 2019-11-18
 *@Time:10:13
 *@Description:${DESCRIPTION}
 **/public class Beana {
    private String status;
    private String message;

    @Override
    public String toString() {
        return "Beana{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Beana(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
