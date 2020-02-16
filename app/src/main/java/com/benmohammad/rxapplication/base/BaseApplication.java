package com.benmohammad.rxapplication.base;

import com.benmohammad.rxapplication.di.component.ApplicationComponent;
import com.benmohammad.rxapplication.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component  = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);
        return component;
    }
}
