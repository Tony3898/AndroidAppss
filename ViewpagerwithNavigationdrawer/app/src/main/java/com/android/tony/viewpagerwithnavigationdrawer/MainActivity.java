package com.android.tony.viewpagerwithnavigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    SimpleFragmentPager simpleFragmentPager;

    @Override
    public void onBackPressed() {
        if(!drawerLayout.isDrawerOpen(navigationView))
        {
            super.onBackPressed();
        }
        else
        {
            drawerLayout.closeDrawers();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navview);
        drawerLayout = findViewById(R.id.drawlayout);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        simpleFragmentPager = new SimpleFragmentPager(getSupportFragmentManager());
        viewPager.setAdapter(simpleFragmentPager);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.firstit:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.secondit:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.thirdit:
                        viewPager.setCurrentItem(2);
                        break;
                }
                menuItem.setCheckable(false);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }
}
