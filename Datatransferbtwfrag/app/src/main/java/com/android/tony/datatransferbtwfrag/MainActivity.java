package com.android.tony.datatransferbtwfrag;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button fragone,fragtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchFrag(new FragOneFragment());

        fragone = findViewById(R.id.fragonebutton);
        fragtwo = findViewById(R.id.fragtwobutton);

        fragone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchFrag(new FragOneFragment());
            }
        });

        fragtwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchFrag(new FragTwoFragment());
            }
        });
    }

    void switchFrag(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }
}
