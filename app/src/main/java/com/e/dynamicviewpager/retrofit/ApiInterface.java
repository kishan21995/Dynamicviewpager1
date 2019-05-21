package com.e.dynamicviewpager.retrofit;



import com.e.dynamicviewpager.model.TabSubChildCatRequestNew;
import com.e.dynamicviewpager.model.TabSubChildCatResponseNew;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("http://vrok.in/grofer_api/child_catall")
    Call<TabSubChildCatResponseNew> getAllSubChildNew(@Body TabSubChildCatRequestNew tabSubChildCatRequestNew);


}
