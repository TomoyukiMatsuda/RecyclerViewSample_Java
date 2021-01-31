package com.android.recyclerviewsample_java.list;

public class TextsViewData implements ViewData {

//    private final int itemId;
//
//    public TextsViewData(int itemId) {
//        this.itemId = itemId;
//    }
    private final String leftText;
    private final String rightText;

    public TextsViewData(String leftText, String rightText) {
        this.leftText = leftText;
        this.rightText = rightText;
    }

    public String getLeftText() {
        return leftText;
    }

    public String getRightText() {
        return rightText;
    }

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
