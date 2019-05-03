package com.android.tony.datatransferbtwfrag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragOneFragment extends Fragment {

    EditText editText;
    Button sumbit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_frag_one, container, false);
        editText = v.findViewById(R.id.editText);
        sumbit = v.findViewById(R.id.sendbutton);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().isEmpty())
                    Toast.makeText(getContext(),"Type something",Toast.LENGTH_SHORT).show();
                else
                {

                    String ms = editText.getText().toString().trim();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    //Toast.makeText(getContext(),ms,Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("msg",ms);
                    Fragment fragTwoFragment = new FragTwoFragment();
                    fragTwoFragment.setArguments(bundle);
                    transaction.replace(R.id.frame,fragTwoFragment).commit();
                }
            }
        });
    }
}
