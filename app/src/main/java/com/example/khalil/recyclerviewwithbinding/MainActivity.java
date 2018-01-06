package com.example.khalil.recyclerviewwithbinding;

import android.databinding.DataBindingUtil;
import android.databinding.InverseBindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.khalil.recyclerviewwithbinding.Adapters.UsersAdapter;
import com.example.khalil.recyclerviewwithbinding.Models.User;
import com.example.khalil.recyclerviewwithbinding.databinding.ActivityMainBinding;

import org.apache.commons.lang3.SerializationUtils;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UsersAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User newUser = new User();
        binding.setNewUser(newUser);

        recyclerView = (RecyclerView) findViewById(R.id.user_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UsersAdapter(new ObservableArrayList<User>());
        recyclerView.setAdapter(adapter);
        User user = new User();
        user.setFirstName("ibrahim");
        user.setLastName("khalil");
        user.setAge(28);
        adapter.add(user);
        addInititalData();
    }

    private void addInititalData() {
        for (int i = 1; i < 15; i++) {
            User user = new User();
            user.setFirstName("ibrahim " + i);
            user.setLastName("khalil " + i);
            user.setAge(28 + i);
            adapter.add(user);
        }
    }

    public void SaveButton_Click(View view) {
      final   ActivityMainBinding binding = DataBindingUtil.findBinding(view);

        final User newUser = binding.getNewUser();
        if (adapter != null && newUser != null) {
            //   adapter.add(newUser); //use if want to keep referrence of new user
            adapter.add(SerializationUtils.clone(newUser)); //deep clone so that referrence of new user will remove
        }
    }


}
