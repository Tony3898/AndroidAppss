package com.android.tony.unittwo;

import android.graphics.Bitmap;

public class GridViewClass {
    Bitmap bitmap;
    String time;

    GridViewClass(Bitmap bitmap,String time)
    {
        this.bitmap = bitmap;
        this.time = time;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getTime() {
        return time;
    }
}
