package com.yrt.uniplay.app.interactor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yrt.uniplay.app.entity.CategroyList;
import com.yrt.uniplay.app.entity.HotProductlist;
import com.yrt.uniplay.app.entity.Result;
import com.yrt.uniplay.app.entity.Root;
import com.yrt.uniplay.app.listener.OnJsonFinshedListener;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Project UniPlay
 * Package com.yrt.uniplay.app.mvp.interactor
 * Author Mengjiaxin
 * Date 2015/12/22 9:13
 * Desc 请用一句话来描述作用
 */
public class JsonInteractorImpl implements IJsonInteractor {

    @Override
    public void findItems(final OnJsonFinshedListener listener) {
        String url = "http://mt.ljgchina.com/p/getProducts/1";
        RequestParams params = new RequestParams(url);

        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String s) {
                List<String> stringList = new ArrayList<String>();
                LogUtil.d("result: " + s);
                JSONObject jsonObject = JSON.parseObject(s);
                Root root = new Root();
                JSONObject resultObject = jsonObject.getJSONObject(Root.FIELD_RESULT);
                Result result = new Result();
                result.setStatus(resultObject.getString(Result.FIELD_STATUS));
                result.setDesc(resultObject.getString(Result.FIELD_DESC));
                root.setResult(result);
                JSONArray categroyArray = jsonObject.getJSONArray(Root.FIELD_CATEGROY_LIST);
                List<CategroyList> categroyLists = new ArrayList<CategroyList>();
                CategroyList categroyList;
                for (int i = 0; i < categroyArray.size(); i++) {
                    categroyList = new CategroyList();
                    categroyList.setId(categroyArray.getJSONObject(i).getIntValue(CategroyList.FIELD_ID));
                    categroyList.setName(categroyArray.getJSONObject(i).getString(CategroyList.FIELD_NAME));
                    categroyLists.add(categroyList);
                }
                root.setCategroyLists(categroyLists);
                JSONArray hotArray = jsonObject.getJSONArray(Root.FIELD_HOT_PRODUCTLIST);
                List<HotProductlist> hotProductlists = new ArrayList<HotProductlist>();
                HotProductlist hotProductlist;
                for (int i = 0; i < hotArray.size(); i++) {
                    hotProductlist = new HotProductlist();
                    hotProductlist.setId(hotArray.getJSONObject(i).getIntValue(HotProductlist.FIELD_ID));
                    hotProductlist.setPrice(hotArray.getJSONObject(i).getDouble(HotProductlist.FIELD_PRICE));
                    hotProductlist.setTitle(hotArray.getJSONObject(i).getString(HotProductlist.FIELD_TITLE));
                    hotProductlist.setUnit(hotArray.getJSONObject(i).getString(HotProductlist.FIELD_UNIT));
                    hotProductlists.add(hotProductlist);

                    stringList.add(hotProductlist.getTitle());
                }
                root.setHotProductlists(hotProductlists);

                listener.onFinshed(stringList);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                LogUtil.e("error!!");
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String s) {
                return false;
            }
        });

    }

}
