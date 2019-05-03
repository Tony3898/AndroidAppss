package com.android.tony.democustomizeandtoolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ThirdFragment extends Fragment {
    Button defaultAlert,customAlert,itemalert,multialert;
    String[] itemarray = {"First","Second","Third"};
    Boolean[] item = {false,false,false};
    String msg ="";
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        defaultAlert = v.findViewById(R.id.defaultalertbutton);
        customAlert = v.findViewById(R.id.customalertbutton);
        itemalert = v.findViewById(R.id.itemalertbutton);
        multialert = v.findViewById(R.id.multialertbutton);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        defaultAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity()).setIcon(R.drawable.self).setTitle("Tony").setMessage("This is Default Alert Box").setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Yo",Toast.LENGTH_LONG).show();
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });

        customAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                View v1 = layoutInflater.inflate(R.layout.custom_toast_layout,null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setView(v1).setIcon(R.drawable.self).setTitle("Tony").setMessage("This is Custom Alert Box").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialogBuilder.create().show();
            }
        });

        itemalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity()).setIcon(R.drawable.self).setTitle("Tony").setItems(itemarray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0)
                            Toast.makeText(getContext(),"You clicked " + itemarray[0],Toast.LENGTH_SHORT).show();
                        else if(which == 1)
                            Toast.makeText(getContext(),"You clicked " + itemarray[1],Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getContext(),"You clicked " + itemarray[2],Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        multialert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setIcon(R.drawable.self).setTitle("Tony").setMultiChoiceItems(itemarray, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        msg = "";
                        item[which] = isChecked;
                    }
                }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i=0;i<item.length;i++)
                        {
                            if(item[i])
                                msg += " " + itemarray[i];
                            item[i] = false;
                        }
                        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
