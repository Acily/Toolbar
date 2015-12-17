package com.app.gaohailong.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donglinghao on 2015-10-30.
 */
public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LinearLayout mLoading;
    private ListView mListView;
    private List<New> mList;
    private NewAdapter mAdapter;
    private int lastItem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        initViews(view);

        initEvent();

        super.onViewCreated(view, savedInstanceState);
    }

    private void initEvent() {
        //下拉刷新监听
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //ListView的item点击监听
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), NewDetail.class);
                startActivity(i);
            }
        });
        //ListView滚动监听
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (lastItem == mAdapter.getCount() && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    //if (view.getLastVisiblePosition() == view.getCount()) {
                    autoLoadingData();
                    //}
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                lastItem = firstVisibleItem + visibleItemCount - 1;
            }
        });
    }

    private void autoLoadingData() {
        mLoading.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.add(new New("cards cards cards cards cards cards the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher, "10min"));
                mList.add(new New("cards cards cards cards cards cards the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher, "10min"));
                mLoading.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            }
        }, 1000);
    }

    private void initViews(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mListView = (ListView) view.findViewById(R.id.list_view);
        View footer = LayoutInflater.from(getActivity()).inflate(R.layout.footer_layout, null, false);
        mLoading = (LinearLayout) footer.findViewById(R.id.footer_loading);
        mListView.addFooterView(footer);

        //刷新图标色彩变换操作
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_red_light);

        mList = new ArrayList<New>();
        mList.add(new New("The use of cards here distracts the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher,"10min"));
        mList.add(new New("The use of cards here distracts the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher,"10min"));
        mList.add(new New("The use of cards here distracts the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher,"10min"));
        mList.add(new New("The use of cards here distracts the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher,"10min"));
        mList.add(new New("The use of cards here distracts the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher,"10min"));
        mList.add(new New("The use of cards here distracts the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher,"10min"));
        mAdapter = new NewAdapter(getActivity(),mList);

        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.add(0,new New("here distracts the user from being able the user from being able to quickly scan. These list items are also not dismissable,also not dismissable.", R.mipmap.ic_launcher,"10min"));
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.notifyDataSetChanged();
            }
        },2000);
    }
}
