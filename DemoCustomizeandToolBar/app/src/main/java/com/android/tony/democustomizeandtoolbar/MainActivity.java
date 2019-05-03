package com.android.tony.democustomizeandtoolbar;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.firstit:
                setFrag(new FirstFragment());
                break;
            case R.id.secondit:
                setFrag(new SecondFragment());
                break;
            case R.id.thirdit:
                setFrag(new ThirdFragment());
                break;
            case R.id.fourit:
                setFrag(new FourFragment());
                break;
        }
        return true;
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting up the view
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.mnavigationView);
        setFrag(new FirstFragment());

        setSupportActionBar(toolbar); // replace toolbar as actionBar

        // setting up click listener on toolbar navigation icon
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
                        setFrag(new FirstFragment());
                        break;
                    case R.id.secondit:
                        setFrag(new SecondFragment());
                        break;
                    case R.id.thirdit:
                        setFrag(new ThirdFragment());
                        break;
                    case R.id.fourit:
                        setFrag(new FourFragment());
                        break;
                }
                menuItem.setCheckable(false);
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    void setFrag(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mframeLayout,fragment);
        fragmentTransaction.commit();
    }
}
