package com.yrt.uniplay.app.entity;

import java.io.Serializable;
import java.util.List;


public class Root implements Serializable{

    public static final String FIELD_RESULT = "result";
    public static final String FIELD_CATEGROY_LIST = "categroyList";
    public static final String FIELD_HOT_PRODUCTLIST = "hotProductlist";


    private Result mResult;
    private List<CategroyList> mCategroyLists;
    private List<HotProductlist> mHotProductlists;


    public Root(){

    }

    public void setResult(Result result) {
        mResult = result;
    }

    public Result getResult() {
        return mResult;
    }

    public void setCategroyLists(List<CategroyList> categroyLists) {
        mCategroyLists = categroyLists;
    }

    public List<CategroyList> getCategroyLists() {
        return mCategroyLists;
    }

    public void setHotProductlists(List<HotProductlist> hotProductlists) {
        mHotProductlists = hotProductlists;
    }

    public List<HotProductlist> getHotProductlists() {
        return mHotProductlists;
    }


}