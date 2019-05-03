package com.android.tony.unittwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridViewAdapter extends ArrayAdapter<GridViewClass> {

    GridViewAdapter(Context context, List<GridViewClass> gridViewClasses)
    {
        super(context,0,gridViewClasses);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_grid_view,parent,false);

        GridViewClass gridViewClass = getItem(position);
        ImageView imageView = convertView.findViewById(R.id.imageViewgrid);
        TextView textView = convertView.findViewById(R.id.textViewgrid);

        imageView.setImageBitmap(gridViewClass.getBitmap());
        textView.setText(gridViewClass.getTime());
        return convertView;
    }
}
