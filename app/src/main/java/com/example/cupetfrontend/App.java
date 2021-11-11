package com.example.cupetfrontend;

import android.app.Application;
import com.example.cupetfrontend.dependency_selector.DependencySelector;

public class App extends Application {
    private DependencySelector dependencySelector;

    @Override
    public void onCreate() {
        super.onCreate();

        dependencySelector = new DependencySelector(this);
    }

    public DependencySelector getDependencySelector() {
        return dependencySelector;
    }
}
