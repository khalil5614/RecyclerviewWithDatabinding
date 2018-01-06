package com.example.khalil.recyclerviewwithbinding.Models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.widget.TextView;

import com.example.khalil.recyclerviewwithbinding.BR;

import java.io.Serializable;

/**
 * Created by Khalil on 10/21/2017.
 */

public class User extends BaseObservable implements Serializable {
    private String firstName;
    private String lastName;
    private int age;

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
