package com.e.dynamicviewpager.mFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.e.dynamicviewpager.R;
import com.e.dynamicviewpager.TabLayoutActivity2;
import com.e.dynamicviewpager.model.TabSubChildCatResponseNew;



public class Fragment1 extends Fragment {
    private String catid;
    private TabSubChildCatResponseNew tabcatitem;
    private RecyclerView recyclerViewSubItem1;

    TabLayoutActivity2 activity;
    String title;

    public Fragment1() {

    }

    public static Fragment1 init(String title) {

        Fragment1 fragment1 = new Fragment1();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment1.setArguments(args);
        return fragment1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (TabLayoutActivity2) getActivity();


    }

    public String getTitle() {
        return title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments() != null ? getArguments().getString("title") : title;
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_fragment1, container, false);
        recyclerViewSubItem1 = rootView.findViewById(R.id.fragmentrecycler);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public String toString() {

        return title;
    }


}
