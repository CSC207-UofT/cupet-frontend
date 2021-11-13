package com.example.cupetfrontend.dependency_selector;

import android.content.Context;

/**
 * This class stores all the dependencies used in the entire
 * Android app (i.e. what specific implementations of controllers,
 * use cases, etc. are we using)
 */
public class DependencySelector {
    private APIDependencies apiDependencies;
    private UserPresenterDependencies userPresenters;
    private PetPresenterDependencies petPresenters;

    private ControllerDependencies controllers;

    public DependencySelector(Context applicationContext) {
        apiDependencies = new APIDependencies(applicationContext);
        userPresenters = new UserPresenterDependencies();
        controllers = new ControllerDependencies(apiDependencies, userPresenters, petPresenters);
    }

    public APIDependencies getApiDependencies() {
        return apiDependencies;
    }

    public UserPresenterDependencies getUserPresenters() {
        return userPresenters;
    }

    public PetPresenterDependencies getPetPresenters() {
        return petPresenters;
    }

    public ControllerDependencies getControllers() {
        return controllers;
    }
}
