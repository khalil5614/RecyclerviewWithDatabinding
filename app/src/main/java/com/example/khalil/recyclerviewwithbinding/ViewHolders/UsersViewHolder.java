package com.example.khalil.recyclerviewwithbinding.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.khalil.recyclerviewwithbinding.Models.User;
import com.example.khalil.recyclerviewwithbinding.databinding.UserlistlayoutBinding;

/**
 * Created by Khalil on 10/21/2017.
 */

public class UsersViewHolder extends RecyclerView.ViewHolder {
    private final UserlistlayoutBinding binding;
    public View layout;

    public UsersViewHolder(UserlistlayoutBinding userlistlayoutBinding) {
        super(userlistlayoutBinding.getRoot());
        layout = userlistlayoutBinding.getRoot();
        this.binding = userlistlayoutBinding;
    }

    public void bind(User user) {
        binding.setUserData(user);
        binding.executePendingBindings();
    }
}
