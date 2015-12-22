package com.yrt.uniplay.app.entity;


import java.io.Serializable;

public class HotProductlist implements Serializable {

    public static final String FIELD_PRICE = "price";
    public static final String FIELD_UNIT = "unit";
    public static final String FIELD_ID = "id";
    public static final String FIELD_TITLE = "title";


    private double mPrice;
    private String mUnit;
    private long mId;
    private String mTitle;


    public HotProductlist() {

    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setUnit(String unit) {
        mUnit = unit;
    }

    public String getUnit() {
        return mUnit;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HotProductlist) {
            return ((HotProductlist) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((Long) mId).hashCode();
    }


}