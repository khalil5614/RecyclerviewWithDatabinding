package com.example.khalil.recyclerviewwithbinding.utils;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.widget.TextView;

/**
 * Created by Khalil on 1/1/2018.
 */

public class BindingAdapterHelpers {
    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        if (view.getText() != null
                && ( !view.getText().toString().isEmpty() )
                && Integer.parseInt(view.getText().toString()) != value) {
            view.setText(Integer.toString(value));
        }
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getText(TextView view) {
        try {
            String numberString = view.getText().toString();
            int number = Integer.parseInt(numberString);
            return number;
        }
        catch (NumberFormatException e) {
            return 0;
        }
    }
}
