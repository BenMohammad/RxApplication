package com.benmohammad.rxapplication.ui.main;

import android.os.Bundle;

import com.benmohammad.rxapplication.R;
import com.benmohammad.rxapplication.base.BaseActivity;
import com.benmohammad.rxapplication.ui.list.ListedFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.screenContainer, new ListedFragment()).commit();
        }
    }
}
