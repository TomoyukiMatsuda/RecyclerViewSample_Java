package com.android.recyclerviewsample_java.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.recyclerviewsample_java.databinding.ItemHeaderBinding;
import com.android.recyclerviewsample_java.databinding.ItemTextsBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// SampleViewHolderの抽象クラス Default を継承することで実際にはアダプターは View の詳細を知らない
// つまり目隠しされているだから再利用が可能である
public class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder.Default> {

    private List<ViewData> viewDataList;

    public SampleAdapter(List<ViewData> viewDataList) {
        this.viewDataList = viewDataList;
    }

    // viewType によって生成するViewHolderの要素　つまりどのレイアウトxml要素を切り替えている、指定している
    @NonNull @Override
    public SampleViewHolder.Default onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == ViewData.Type.HEADER) {
            ItemHeaderBinding binding =
                    ItemHeaderBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup,
                            false);

            // ここでインスタンス化してバインディング要素を引数で渡している
            return new SampleViewHolder.Header(binding);
        }

        ItemTextsBinding binding =
                ItemTextsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup,
                        false);

        // ここでインスタンス化
        return new SampleViewHolder.Texts(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder.Default viewHolder, int position) {
        // viewHolderが持っているbindメソッドで要素をバインディング
        viewHolder.bind(viewDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return viewDataList.size();
    }

    // TODO: これいる？
    @Override
    public int getItemViewType(int position) {
        return viewDataList.get(position).getType();
    }
}
