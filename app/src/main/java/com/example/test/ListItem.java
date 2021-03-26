package com.example.test;

import android.net.Uri;
import android.widget.ImageView;

public class ListItem {
    String _itemListTitle;

    public ListItem(String _itemListTitle) {
        this._itemListTitle = _itemListTitle;

    }



    public String get_itemListTitle() {
        return _itemListTitle;
    }

    public void set_itemListTitle(String _itemListTitle) {
        this._itemListTitle = _itemListTitle;
    }
}
