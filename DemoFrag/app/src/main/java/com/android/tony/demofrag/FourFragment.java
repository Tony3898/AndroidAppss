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
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FourFragment extends Fragment {

    Button show;
    TextView result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_four, container, false);

        result = v.findViewById(R.id.result);
        show = v.findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File sdCard = Environment.getExternalStorageDirectory();
                File file  = new File(sdCard.getAbsolutePath(),"/Users");
                File outFile = new File(file,"users.txt");

                if(!outFile.exists())
                {
                    Toast.makeText(getContext(),"No Users",Toast.LENGTH_LONG).show();
                    result.setText("no users");
                }
                else
                {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(outFile);
                        int c=0;
                        String msg="";
                        while((c=fileInputStream.read())!=-1)
                        {
                           msg += Character.toString((char) c );
                        }
                        fileInputStream.close();
                        result.setText(msg);
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
