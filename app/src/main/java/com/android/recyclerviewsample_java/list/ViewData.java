package com.android.recyclerviewsample_java.list;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface ViewData {

    // 全体的にわからないことが多すぎる
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ Type.HEADER, Type.TEXTS, Type.FORM_BUTTON })
    @interface Type {
        int HEADER = 1;
        int TEXTS = 2;
        int FORM_BUTTON = 3;
    }

    @Type int getType();

    //int getItemId();
}
