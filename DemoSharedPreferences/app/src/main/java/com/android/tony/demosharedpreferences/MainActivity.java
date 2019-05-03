package com.android.tony.demosharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button write,read;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        write = findViewById(R.id.writebutton);
        read = findViewById(R.id.readbutton);
        editText = findViewById(R.id.editText);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("Demo",MODE_PRIVATE);
                if(editText.getText().toString().trim().isEmpty())
                    Toast.makeText(getApplicationContext(),"Please Type Something",Toast.LENGTH_SHORT).show();
                else
                {
                    sharedPreferences.edit().putString("input",editText.getText().toString().trim()).apply();
                    Toast.makeText(getApplicationContext(),"Upoaded",Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("Demo",MODE_PRIVATE);
                String file = sharedPreferences.getString("input","Nothing");
                Toast.makeText(getApplicationContext(),file,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
