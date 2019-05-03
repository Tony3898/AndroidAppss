package com.android.tony.unittwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListviewClass> {

    ListViewAdapter(Context context,List<ListviewClass> listviewClasses)
    {
        super(context,0,listviewClasses);
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view,parent,false);
        ListviewClass listviewClass = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.customlistviewimageView);
        TextView textView = convertView.findViewById(R.id.customlistviewtextView);

        imageView.setImageBitmap(listviewClass.getBitmap());
        textView.setText(listviewClass.getTime());
        return convertView;
    }
}
