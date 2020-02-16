package com.benmohammad.rxapplication.di.component;

import android.app.Application;

import com.benmohammad.rxapplication.base.BaseApplication;
import com.benmohammad.rxapplication.di.module.ActivityBindingModule;
import com.benmohammad.rxapplication.di.module.ApplicationModule;
import com.benmohammad.rxapplication.di.module.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {


    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        ApplicationComponent build();
    }
}
