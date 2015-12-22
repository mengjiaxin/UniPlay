package com.yrt.uniplay.app.entity;


import java.io.Serializable;

public class Result implements Serializable {

    public static final String FIELD_STATUS = "status";
    public static final String FIELD_DESC = "desc";


    private String mStatus;
    private String mDesc;


    public Result() {

    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public String getDesc() {
        return mDesc;
    }


}