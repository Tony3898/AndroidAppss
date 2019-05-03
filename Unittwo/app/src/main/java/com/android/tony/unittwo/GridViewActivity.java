package com.android.tony.unittwo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    Bundle bundle;
    Bitmap bitmap;
    GridView gridView;
    List<GridViewClass> gridViewClassList;
    GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.gridview);
        gridViewClassList = new ArrayList<>();
        gridViewAdapter = new GridViewAdapter(getApplicationContext(),gridViewClassList);
        gridView.setAdapter(gridViewAdapter);
        floatingActionButton = findViewById(R.id.gridfloatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            bundle = data.getExtras();
            bitmap = (Bitmap) bundle.get("data");
            gridViewClassList.add(new GridViewClass(bitmap,String.valueOf(new Date())));
            gridViewAdapter.notifyDataSetChanged();
        }
    }
}
