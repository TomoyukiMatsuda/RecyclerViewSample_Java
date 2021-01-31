package com.android.recyclerviewsample_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewDataGenerator {

    // なぜ static にしている？
    public static List<ViewData> generateViewDataList() {
        final List<ViewData> viewDataList = new ArrayList<>();
        ViewDataGenerator instance = new ViewDataGenerator();

        // リストに追加していく処理を書いてゆく
        viewDataList.addAll(instance.firstCell());
        viewDataList.addAll(instance.secondCell());

        return viewDataList;
    }

    // 最初のセル要素
    private List<ViewData> firstCell() {
        final HeaderViewData header = new HeaderViewData();
        final TextsViewData texts = new TextsViewData();

        return Arrays.asList(header, texts);
    }

    // ２番目のセル
    private List<ViewData> secondCell() {
        final HeaderViewData header = new HeaderViewData();
        final TextsViewData firstTexts = new TextsViewData();
        final TextsViewData secondTexts = new TextsViewData();

        return Arrays.asList(header, firstTexts, secondTexts);
    }
}
