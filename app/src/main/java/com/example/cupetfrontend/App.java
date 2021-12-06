package com.example.cupetfrontend;

import android.app.Application;

import com.example.cupetfrontend.dagger_dependencies.AppComponent;
import com.example.cupetfrontend.dagger_dependencies.DaggerAppComponent;
import com.example.cupetfrontend.dagger_dependencies.modules.AppModule;
import com.example.cupetfrontend.dependency_selector.DependencySelector;

public class App extends Application {
    private DependencySelector dependencySelector;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        dependencySelector = new DependencySelector(this);
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public DependencySelector getDependencySelector() {
        return dependencySelector;
    }
}
