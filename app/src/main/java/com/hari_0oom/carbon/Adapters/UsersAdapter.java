package com.hari_0oom.carbon.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hari_0oom.carbon.Models.Users;
import com.hari_0oom.carbon.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    ArrayList<Users> list;
    Context context;

    public UsersAdapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users user=list.get(position);
        Picasso.get().load(user.getProfilepic()).placeholder(R.drawable.logo).into(holder.image);
        holder.userNmae.setText(user.getUserName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       ImageView image;
       TextView userNmae, lastMessage;

       public ViewHolder(@NonNull View itemView){
           super(itemView);

           image=itemView.findViewById(R.id.profile_image);
           userNmae=itemView.findViewById(R.id.userName);
           lastMessage=itemView.findViewById(R.id.lastMessage);

       }

   }
}
