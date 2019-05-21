package com.e.dynamicviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.e.dynamicviewpager.mFragments.Fragment1;
import com.e.dynamicviewpager.mFragments.MyPagerAdapter;
import com.e.dynamicviewpager.model.TabSubChildCatRequestNew;
import com.e.dynamicviewpager.model.TabSubChildCatResponseNew;
import com.e.dynamicviewpager.model.TabSubChildCategoryNew;
import com.e.dynamicviewpager.retrofit.RestClient;
import com.e.dynamicviewpager.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabLayoutActivity2 extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener {

    ViewPager viewPager;
    TabLayout tabLayout;
    private String sub_cat_id="5";
    private final String TAG = TabLayoutActivity2.class.getSimpleName();


    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout2);


        viewPager = findViewById(R.id.mViewpager_ID2);

        getAllSubCategories( sub_cat_id);

        tabLayout = findViewById(R.id.mTab_ID2);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(this);


    }

    private void getAllSubCategories( String sub_cat_id) {

       TabSubChildCatRequestNew tabSubChildCatRequestNew = new TabSubChildCatRequestNew();
        tabSubChildCatRequestNew.setSubId(sub_cat_id);

        Utils.showProgressDialog(TabLayoutActivity2.this, "Please wait...");
        RestClient.tabAllSubChildNew2(tabSubChildCatRequestNew, new Callback<TabSubChildCatResponseNew>() {
            @Override
            public void onResponse(Call<TabSubChildCatResponseNew> call, Response<TabSubChildCatResponseNew> response) {
                Utils.dismissProgressDialog();

                if (response != null) {
                    addPages(response.body());
                }

            }

            @Override
            public void onFailure(Call<TabSubChildCatResponseNew> call, Throwable t) {
                Utils.dismissProgressDialog();
                Log.d(TAG, " Error in sub cat child api" + t.getMessage());

            }
        });
    }

    //view pager
    private void addPages(TabSubChildCatResponseNew body) {

        pagerAdapter = new MyPagerAdapter(this.getSupportFragmentManager());

        for (int i = 0 ; i < body.getSubChildCategories().size(); i++) {

            TabSubChildCategoryNew tabSubChildCategoryNew = body.getSubChildCategories().get(i);

            pagerAdapter.addFragment(Fragment1.init(tabSubChildCategoryNew.getCTitle()));






        }
        viewPager.setOffscreenPageLimit(body.getSubChildCategories().size());

        viewPager.setAdapter(pagerAdapter);


    }

    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
