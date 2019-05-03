package com.android.tony.demointernalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button write,read;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        write = findViewById(R.id.writebutton);
        read = findViewById(R.id.readbutton);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().isEmpty())
                    editText.setError("Enter Your Name");
                else
                {
                    String name = editText.getText().toString().trim();
                    try {

                        FileOutputStream fileOutputStream = openFileOutput("Tony.txt",MODE_PRIVATE);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                        outputStreamWriter.write(name);
                        outputStreamWriter.close();
                        editText.setText("");
                        Toast.makeText(getApplicationContext(),"Data Uploaded",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream = openFileInput("Tony.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    textView.setText("Name: " + bufferedReader.readLine());

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
