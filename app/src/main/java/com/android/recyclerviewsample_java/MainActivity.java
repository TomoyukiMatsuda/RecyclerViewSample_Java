package com.android.recyclerviewsample_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.android.recyclerviewsample_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウト要素をバインディング
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Fragmentを表示
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(binding.layoutContainer.getId(), new RecyclerViewFragment())
                .commit();
    }
}
