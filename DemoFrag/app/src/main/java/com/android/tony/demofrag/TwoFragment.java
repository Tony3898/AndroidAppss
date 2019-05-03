package com.android.tony.demofrag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class TwoFragment extends Fragment {


    EditText firstNameEditText, lastNameEditText, registerEditText;
    Button signUp;
    FileOutputStream fileOutputStream;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_two, container, false);

        signUp = v.findViewById(R.id.signupbutton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File sdCard = Environment.getExternalStorageDirectory();
                File file  = new File(sdCard.getAbsolutePath(),"/Users");
                File outFile = new File(file,"users.txt");
                if(!file.exists())
                {
                    if(file.mkdirs())
                        Toast.makeText(getContext(),"File Created",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getContext(),"not File Created",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getContext(),"sd not File Created",Toast.LENGTH_LONG).show();

                try {
                    fileOutputStream = new FileOutputStream(outFile,true);

                    firstNameEditText = (EditText) v.findViewById(R.id.firstname);
                    lastNameEditText = (EditText) v.findViewById(R.id.lastname);
                    registerEditText = (EditText) v.findViewById(R.id.register);

                    if ( firstNameEditText.getText().toString().isEmpty() || lastNameEditText.getText().toString().isEmpty() || registerEditText.getText().toString().isEmpty()) {
                         Toast.makeText(getContext(), " Please fill all the blank space", Toast.LENGTH_LONG).show();
                    } else {
                        //Words words = new Words(firstNameEditText.getText().toString(), lastNameEditText.getText().toString(), Integer.parseInt(registerEditText.getText().toString()));
                        String input = firstNameEditText.getText().toString().trim() + " " + lastNameEditText.getText().toString().trim() + " " + registerEditText.getText().toString().trim();
                        byte inputByte[] = input.getBytes();
                        for (byte msg:inputByte) {
                            fileOutputStream.write(msg);
                        }
                        fileOutputStream.write(10);
                        fileOutputStream.close();
                        Toast.makeText(getContext(), " " + input, Toast.LENGTH_LONG).show();
                    }

                } catch (IOException e) {
                    Toast.makeText(getContext(), " " + e, Toast.LENGTH_LONG).show();
                }
            }

        });

        return v;
    }
}




