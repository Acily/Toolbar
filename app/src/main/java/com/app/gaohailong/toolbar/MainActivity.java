package com.app.gaohailong.toolbar;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ImageView mHeadShow;
    private LinearLayout mQQ,mDrawerHeader;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private String[] mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initDrawerLayout();

        initEvent();

        /*Window window = getWindow();
        window.setStatusBarColor(Color.BLUE);
        mToolbar.setBackgroundColor(Color.RED);
        mTabLayout.setBackgroundColor(Color.RED);
        mDrawerHeader.setBackgroundColor(Color.RED);*/
    }

    private void initViews() {
        //initViews
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mHeadShow = (ImageView) findViewById(R.id.head_show);
        mQQ = (LinearLayout) findViewById(R.id.tengxun_qq);
        mDrawerHeader = (LinearLayout) findViewById(R.id.drawer_header);
        //initData
        mTitles = new String[]{"首页","个性推荐","排行榜"};

        mFragments = new ArrayList<Fragment>();
        Fragment mHomeFragment = new HomeFragment();
        Fragment mIntroduceFragment = new IntroduceFragment();
        Fragment mRankingFragment = new RankingFragment();
        mFragments.add(mHomeFragment);
        mFragments.add(mIntroduceFragment);
        mFragments.add(mRankingFragment);
        //TabLayout,ViewPager
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initEvent() {
        mHeadShow.setOnClickListener(this);
        mQQ.setOnClickListener(this);
    }

    private void initDrawerLayout() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.head_show:
                Toast.makeText(MainActivity.this,"头像",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tengxun_qq:
                Toast.makeText(MainActivity.this,"腾讯QQ",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
