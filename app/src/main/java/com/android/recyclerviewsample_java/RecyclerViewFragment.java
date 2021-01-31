package com.android.recyclerviewsample_java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.recyclerviewsample_java.databinding.FragmentRecyclerViewBinding;

public class RecyclerViewFragment extends Fragment {

    private FragmentRecyclerViewBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    // onViewCreated と onCreateView の使い分け方が不明
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // view とバインディング
        binding = FragmentRecyclerViewBinding.bind(view);
        // アダプターをセット
        SampleAdapter adapter = new SampleAdapter(ViewDataGenerator.generateViewDataList());
        // list はレイアウトのid list にアクセスさせている
        binding.list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.list.setAdapter(adapter);
    }
}



