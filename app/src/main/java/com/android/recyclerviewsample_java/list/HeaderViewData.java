package com.android.recyclerviewsample_java.list;

import com.android.recyclerviewsample_java.list.ViewData;

public class HeaderViewData implements ViewData {

//    private final int itemId;
//
//    public HeaderViewData(int itemId) {
//        this.itemId = itemId;
//    }
    private final String title;

    HeaderViewData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int getType() {
        return Type.HEADER;
    }

//    @Override
//    public int getItemId() {
//        return itemId;
//    }
}
