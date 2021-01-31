package com.android.recyclerviewsample_java;

public class HeaderViewData implements ViewData {

//    private final int itemId;
//
//    public HeaderViewData(int itemId) {
//        this.itemId = itemId;
//    }

    @Override
    public int getType() {
        return Type.HEADER;
    }

//    @Override
//    public int getItemId() {
//        return itemId;
//    }
}
