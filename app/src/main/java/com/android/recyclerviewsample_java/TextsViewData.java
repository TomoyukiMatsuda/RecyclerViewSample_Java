package com.android.recyclerviewsample_java;

public class TextsViewData implements ViewData {

//    private final int itemId;
//
//    public TextsViewData(int itemId) {
//        this.itemId = itemId;
//    }

    @Override
    public int getType() {
        // ViewDataのTypeにアクセスできる　すごい
        return Type.TEXTS;
    }

//    @Override
//    public int getItemId() {
//        return itemId;
//    }
}
