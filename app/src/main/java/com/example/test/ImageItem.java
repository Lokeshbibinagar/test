package com.example.test;

import android.net.Uri;
import android.widget.ImageView;

public class ImageItem {

     Uri img;

    public ImageItem(Uri img) {
        this.img = img;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }
}
