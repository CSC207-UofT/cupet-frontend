package com.example.cupetfrontend;

import android.app.Application;

import com.example.cupetfrontend.dagger_dependencies.AppComponent;
import com.example.cupetfrontend.dagger_dependencies.DaggerAppComponent;
import com.example.cupetfrontend.dagger_dependencies.modules.AppModule;

public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
