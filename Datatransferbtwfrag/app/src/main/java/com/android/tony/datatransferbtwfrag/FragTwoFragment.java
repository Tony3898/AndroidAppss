package com.android.tony.datatransferbtwfrag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FragTwoFragment extends Fragment {


    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_two, container, false);
        textView = v.findViewById(R.id.revtext);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();

        if(bundle!=null) {
            textView.setText(bundle.getString("msg"));
            Toast.makeText(getContext(),bundle.getString("msg"),Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
        }
    }
}
