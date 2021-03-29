package com.example.test;

import android.net.Uri;
import android.widget.ImageView;

import java.util.ArrayList;

public class ListItem {
    String _itemListTitle;
    ArrayList<Uri> _imageList;

    public ListItem(String _itemListTitle) {
        this._itemListTitle = _itemListTitle;
    }

    public ListItem(ArrayList<Uri> _imageList) {
        this._imageList = _imageList;
    }

    public ArrayList<Uri> get_imageList() {
        return _imageList;
    }

    public void set_imageList(ArrayList<Uri> _imageList) {
        this._imageList = _imageList;
    }

    public String get_itemListTitle() {
        return _itemListTitle;
    }

    public void set_itemListTitle(String _itemListTitle) {
        this._itemListTitle = _itemListTitle;
    }
}
