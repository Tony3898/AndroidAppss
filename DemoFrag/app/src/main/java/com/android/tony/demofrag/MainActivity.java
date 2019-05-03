package com.android.tony.demofrag;

import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabLayout tabLayout = findViewById(R.id.slidingtab);
        ViewPager viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);
        SimpleFragmentsPagerAdapter simpleFragmentsPagerAdapter = new SimpleFragmentsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(simpleFragmentsPagerAdapter);



    }
}
