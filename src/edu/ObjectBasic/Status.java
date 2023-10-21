package edu.ObjectBasic;

public enum Status {
    Running("跑步"), Sleeping("睡觉"), Walking("行走");

    String status;

    Status() {
    }

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
