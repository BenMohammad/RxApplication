package com.benmohammad.rxapplication.di.module;

import com.benmohammad.rxapplication.di.module.ApplicationModule;
import com.benmohammad.rxapplication.di.module.ContextModule;
import com.benmohammad.rxapplication.ui.main.MainActivity;
import com.benmohammad.rxapplication.ui.main.MainFragmentBindingModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {


    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
