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
import java.io.FileInputStream;
import java.io.IOException;


public class ThreeFragment extends Fragment {
    Button signUpButton;
    EditText logreg;
    int flag=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_three, container, false);
        signUpButton = v.findViewById(R.id.signup);
        logreg = v.findViewById(R.id.loginreg);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File sdCard = Environment.getExternalStorageDirectory();
                File file  = new File(sdCard.getAbsolutePath(),"/Users");
                File outFile = new File(file,"users.txt");

                if(!outFile.exists())
                    Toast.makeText(getContext(),"No Users Entered",Toast.LENGTH_LONG).show();
                else
                    {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(outFile);
                            int c=0,i=0;
                            String msg="";
                            while((c=fileInputStream.read())!=-1)
                            {
                                msg += Character.toString((char) c );
                            }

                            String msgSplit[] = msg.split("\n");

                            for (String msgsplit: msgSplit) {
                                String msgsp[] = msgsplit.split(" ");
                                if(msgsp[2].equals(logreg.getText().toString())) {
                                    Toast.makeText(getContext(), msgsplit, Toast.LENGTH_LONG).show();
                                    flag=1;
                                }
                            }
                            if(flag==0)
                                Toast.makeText(getContext(), "No users", Toast.LENGTH_LONG).show();
                            fileInputStream.close();

                        }
                        catch (IOException e)
                        {
                            Toast.makeText(getContext()," " + e,Toast.LENGTH_LONG).show();
                        }
                }
            }
        });
        return v;
    }

}
