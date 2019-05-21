package com.e.dynamicviewpager.retrofit;



import com.e.dynamicviewpager.model.TabSubChildCatRequestNew;
import com.e.dynamicviewpager.model.TabSubChildCatResponseNew;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";

    public static void tabAllSubChildNew2(TabSubChildCatRequestNew tabSubChildCatRequestNew, Callback<TabSubChildCatResponseNew> callback) {
        RetrofitClient.getClient().getAllSubChildNew(tabSubChildCatRequestNew).enqueue(callback);
    }


}



