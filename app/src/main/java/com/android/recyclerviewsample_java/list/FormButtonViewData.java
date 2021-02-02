package com.android.recyclerviewsample_java.list;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.android.recyclerviewsample_java.BR;

// すでに継承しているため、多重継承できなそう
public class FormButtonViewData extends BaseObservable implements ViewData {

    private String formText;

    @Override
    public int getType() {
        return Type.FORM_BUTTON;
    }

    @Bindable public String getFormText() {
        return formText;
    }

    public void setFormText(String formText) {
        this.formText = formText;
        notifyPropertyChanged(BR.buttonEnable);
    }

    // public 必須
    @Bindable public boolean isButtonEnable() {
        return !TextUtils.isEmpty(formText);
    }
}
