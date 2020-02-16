package com.benmohammad.rxapplication.ui.main;



import com.benmohammad.rxapplication.ui.detail.DetailsFragment;
import com.benmohammad.rxapplication.ui.list.ListedFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract ListedFragment provideListFragment();

    @ContributesAndroidInjector
    abstract DetailsFragment provideDetailsFragment();
}
