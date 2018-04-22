package com.jsksolutions.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.jsksolutions.data.DataManager;
import com.jsksolutions.injection.ApplicationContext;
import com.jsksolutions.injection.module.AppModule;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager apiManager();
}
