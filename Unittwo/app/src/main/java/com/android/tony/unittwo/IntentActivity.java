package com.android.tony.unittwo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Button email= findViewById(R.id.emailintentbutton);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("email"));
                String[] emails = {"Tonyrana3898@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,emails);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Android Apps");
                intent.putExtra(Intent.EXTRA_TEXT,"Thanks for providing codes");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent,"Email");
                startActivity(chooser);
            }
        });

        Button web = findViewById(R.id.webintentbutton);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/Tony3898"));
                startActivity(intent);
            }
        });
    }
}
