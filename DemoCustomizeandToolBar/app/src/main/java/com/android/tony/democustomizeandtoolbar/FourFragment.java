package com.android.tony.democustomizeandtoolbar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


public class FourFragment extends Fragment {

    Button customProgress,defaultProgress;
    ProgressBar defaultbar,custombar;
    int prog=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_four, container, false);
        customProgress = v.findViewById(R.id.customprogressbutton);
        defaultProgress = v.findViewById(R.id.defaultprogressbutton);
        custombar = v.findViewById(R.id.customprogressBar);
        defaultbar = v.findViewById(R.id.defaultprogressBar);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        defaultProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custombar.setVisibility(View.GONE);
                defaultbar.setVisibility(View.VISIBLE);
                setProgress(0);

            }
        });

        customProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custombar.setVisibility(View.VISIBLE);
                setProgress(0);
                defaultbar.setVisibility(View.GONE);
            }
        });


    }

    void setProgress(int progress)
    {
        this.prog = progress;
        defaultbar.setProgress(prog);
        custombar.setProgress(prog);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                setProgress(prog+25);


            }
        });
        thread.start();
    }
}
