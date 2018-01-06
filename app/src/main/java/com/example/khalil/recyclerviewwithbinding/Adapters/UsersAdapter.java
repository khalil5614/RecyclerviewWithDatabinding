package com.example.khalil.recyclerviewwithbinding.Adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khalil.recyclerviewwithbinding.MainActivity;
import com.example.khalil.recyclerviewwithbinding.Models.User;
import com.example.khalil.recyclerviewwithbinding.R;
import com.example.khalil.recyclerviewwithbinding.ViewHolders.UsersViewHolder;
import com.example.khalil.recyclerviewwithbinding.databinding.ActivityMainBinding;
import com.example.khalil.recyclerviewwithbinding.databinding.UserlistlayoutBinding;

/**
 * Created by Khalil on 10/21/2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersViewHolder> {

  private ObservableArrayList<User> users;

    public UsersAdapter(ObservableArrayList<User> users) {
        this.users = users;
    }

    public void add(User user){
        users.add(user);
        notifyItemRangeChanged(0,getItemCount());
    }

    public void add(int position, User user) {
        users.add(position, user);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        users.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserlistlayoutBinding binding = UserlistlayoutBinding.inflate(inflater, parent, false);
        return new UsersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final UsersViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
