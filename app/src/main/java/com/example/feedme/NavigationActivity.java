package com.example.feedme;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    TextView title;

    private ArrayList<Fragment> mFragmentList = new ArrayList<Fragment>();

    private int lastPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除工具栏
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_navigation);

        initViews();



    }

    /**
     * 初始化布局View
     */
    private void initViews() {
        title = findViewById(R.id.title);
        mBottomNavigationView = findViewById(R.id.btm_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.explore:
                        setFragment(0);
                        break;
                    case R.id.shopping_cart:
                        setFragment(1);
                        break;
                    case R.id.menu:
                        setFragment(2);
                        break;
                    case R.id.inbox:
                        setFragment(3);
                        break;
                    case R.id.profile:
                        setFragment(4);
                        break;
                        default:
                            break;
                }
                return true;
            }
        });




        //给FragmentList添加数据
        mFragmentList.add(new ExploreFragment());
        mFragmentList.add(new ShoppingCartFragment());
        mFragmentList.add(new MenuFragment());
        mFragmentList.add(new InboxFragment());
        mFragmentList.add(new PofileFragment());

        setFragment(0);
    }

    private void setFragment(int position){
        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
        Fragment nextFragment = new Fragment();
        nextFragment = mFragmentList.get(position);
        Fragment previousFragment = new Fragment();
        previousFragment = mFragmentList.get(lastPosition);

        lastPosition = position;

        tr.hide(previousFragment);

        if(!nextFragment.isAdded())
            tr.add(R.id.fragmentdisplay,nextFragment);
            tr.show(nextFragment);

        tr.commitAllowingStateLoss();
    }


}

