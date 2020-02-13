package com.benmohammad.rxapplication.ui.main;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.benmohammad.rxapplication.R;
import com.benmohammad.rxapplication.base.BaseActivity;
import com.benmohammad.rxapplication.ui.list.ListFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {

        }
    }
}
