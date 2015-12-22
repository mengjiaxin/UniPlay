package com.yrt.uniplay.app.entity;


import java.io.Serializable;

public class CategroyList implements Serializable {

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";


    private long mId;
    private String mName;


    public CategroyList() {

    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CategroyList) {
            return ((CategroyList) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((Long) mId).hashCode();
    }


}