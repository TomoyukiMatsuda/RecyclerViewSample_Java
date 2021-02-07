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
import com.android.recyclerviewsample_java.list.SampleAdapter;
import com.android.recyclerviewsample_java.list.SampleViewHolder;
import com.android.recyclerviewsample_java.list.ViewDataGenerator;

import javax.inject.Inject;
import javax.inject.Scope;

import dagger.Binds;
import dagger.Module;

public class RecyclerViewFragment extends Fragment {

    private FragmentRecyclerViewBinding binding;

    // TODO: これで注入されてる？現状されていなそう
      // Module を定義する必要ありそうなので利用できるようにする
    @Inject
    SampleViewHolder.Listener listener;

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
        SampleAdapter adapter = new SampleAdapter(ViewDataGenerator.generateViewDataList(), listener);
        // list はレイアウトのid list にアクセスさせている
        binding.list.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.list.setAdapter(adapter);
    }
}



