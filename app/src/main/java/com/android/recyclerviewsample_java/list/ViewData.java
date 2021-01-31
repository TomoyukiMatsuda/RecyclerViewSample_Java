package com.android.recyclerviewsample_java.list;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ViewData {

    // 全体的にわからないことが多すぎる
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ Type.HEADER, Type.TEXTS })
    @interface Type {
        int HEADER = 1;
        int TEXTS = 2;
    }

    @Type int getType();

    //int getItemId();
}
