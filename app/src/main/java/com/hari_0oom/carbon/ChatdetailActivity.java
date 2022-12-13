package com.hari_0oom.carbon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hari_0oom.carbon.databinding.ActivityChatdetailBinding;

public class ChatdetailActivity extends AppCompatActivity {
    ActivityChatdetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityChatdetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}