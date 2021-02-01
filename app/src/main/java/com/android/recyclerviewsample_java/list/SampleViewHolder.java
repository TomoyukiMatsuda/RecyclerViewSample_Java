package com.android.recyclerviewsample_java.list;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.android.recyclerviewsample_java.databinding.ItemFormButtonBinding;
import com.android.recyclerviewsample_java.databinding.ItemHeaderBinding;
import com.android.recyclerviewsample_java.databinding.ItemTextsBinding;

public class SampleViewHolder {

    // 抽象クラス <T extends OrderViewData>はOrderViewDataを継承しているクラスに限定しているってこと？
    public static abstract class Default<T extends ViewData> extends RecyclerView.ViewHolder {
        public Default(ViewDataBinding viewDataBinding) {
            // レイアウト にアクセスしている
            // public ViewHolder(@NonNull View itemView) {
            //    if (itemView == null) {
            //          throw new IllegalArgumentException("itemView may not be null");
            //    }
            //    this.itemView = itemView;
            // }
            // これのはず ↓↑
            super(viewDataBinding.getRoot());
        }

        // 抽象メソッド　型を限定していないジェネリクス型
        public abstract void bind(T viewData);
    }

    // ここで形がわかる？
    public static class Header extends Default<HeaderViewData> {
        // item_header.xml の Binding 要素？
        private final ItemHeaderBinding itemHeaderBinding;

        // コンストラクタ
        public Header(ItemHeaderBinding itemHeaderBinding) {
            super(itemHeaderBinding);
            // インスタンス化するときにバインディング要素を取得
            this.itemHeaderBinding = itemHeaderBinding;
        }

        @Override
        public void bind(HeaderViewData viewData) {
            // viewData をレイアウト要素と結びつけている
            itemHeaderBinding.setViewData(viewData);
        }
    }

    public static class Texts extends Default<TextsViewData> {
        // item_texts.xml の Binding 要素
        private final ItemTextsBinding itemTextsBinding;

        // コンストラクタ
        public Texts(ItemTextsBinding itemTextsBinding) {
            super(itemTextsBinding);
            // インスタンス化するときにバインディング要素を取得
            this.itemTextsBinding = itemTextsBinding;
        }

        @Override
        public void bind(TextsViewData viewData) {
            // viewData をレイアウト要素と結びつけている
            itemTextsBinding.setViewData(viewData);
        }
    }

    public static class FormButton extends Default<FormButtonViewData> {
        private final ItemFormButtonBinding itemFormButtonBinding;

        public FormButton(ItemFormButtonBinding itemFormButtonBinding) {
            super(itemFormButtonBinding);

            this.itemFormButtonBinding = itemFormButtonBinding;
        }

        @Override
        public void bind(FormButtonViewData viewData) {
            // setViewData() の set~ は xml の<variable name="viewData" の命名に基づいて生成されるメソッド
            itemFormButtonBinding.setViewData(viewData);
        }
    }
}
