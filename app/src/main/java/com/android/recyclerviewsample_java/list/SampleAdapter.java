package com.android.recyclerviewsample_java.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.recyclerviewsample_java.databinding.ItemFormButtonBinding;
import com.android.recyclerviewsample_java.databinding.ItemHeaderBinding;
import com.android.recyclerviewsample_java.databinding.ItemTextsBinding;
import java.util.List;

// SampleViewHolderの抽象クラス Default を継承することで実際にはアダプターは View の詳細を知らない
// つまり目隠しされているだから再利用が可能である
public class SampleAdapter extends RecyclerView.Adapter<SampleViewHolder.Default> {

    @Nullable private final SampleViewHolder.Listener listener;
    private List<ViewData> viewDataList;

    public SampleAdapter(List<ViewData> viewDataList, @Nullable SampleViewHolder.Listener listener) {
        this.listener = listener;
        this.viewDataList = viewDataList;
    }

    // viewType によって生成するViewHolderの要素　つまりどのレイアウトxml要素を切り替えている、指定している
    @NonNull @Override
    public SampleViewHolder.Default onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            case ViewData.Type.HEADER: {
                // バインディングオブジェクトを生成
                ItemHeaderBinding binding =
                        ItemHeaderBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup,
                                false);

                // SampleViewHolderの内部クラスにDataBindingオブジェクトを渡しながらインスタンス化している
                return new SampleViewHolder.Header(binding);
            }

            case ViewData.Type.TEXTS: {
                ItemTextsBinding binding =
                        ItemTextsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup,
                                false);

                return new SampleViewHolder.Texts(binding);
            }

            default: {
                ItemFormButtonBinding binding =
                        ItemFormButtonBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup,
                                false);

                return new SampleViewHolder.FormButton(binding);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder.Default viewHolder, int position) {
        // viewHolderが持っているbindメソッドで要素をバインディング

        viewHolder.bind(viewDataList.get(position), listener);
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
