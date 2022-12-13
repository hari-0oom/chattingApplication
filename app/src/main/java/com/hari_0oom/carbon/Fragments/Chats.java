package com.hari_0oom.carbon.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hari_0oom.carbon.Adapters.UsersAdapter;
import com.hari_0oom.carbon.Models.Users;
import com.hari_0oom.carbon.R;
import com.hari_0oom.carbon.databinding.FragmentChatsBinding;

import java.util.ArrayList;

public class Chats extends Fragment {

    public Chats() {
        // Required empty public constructor
    }

    FragmentChatsBinding binding;
    ArrayList<Users> list=new ArrayList<>();
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentChatsBinding.inflate(inflater, container, false);

        database=FirebaseDatabase.getInstance();
        UsersAdapter adapter= new UsersAdapter(list, getContext());
        binding.chatRecyclerVIew.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        binding.chatRecyclerVIew.setLayoutManager(layoutManager);

        database.getReference().child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot datasnapshot: snapshot.getChildren()){
                    Users users= datasnapshot.getValue(Users.class);
                    users.getUserId(datasnapshot.getKey());
                    list.add(users);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return binding.getRoot();
    }
}