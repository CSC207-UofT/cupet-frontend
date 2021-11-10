package com.example.cupetfrontend.dependency_selector;

import android.content.Context;
import com.example.cupetfrontend.controllers.UserController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.drivers.api.UserAPIGateway;
import com.example.cupetfrontend.use_cases.UserCreator;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;

/**
 * This class stores all the dependencies used in the entire
 * Android app (i.e. what specific implementations of controllers,
 * use cases, etc. are we using)
 */
public class DependencySelector {
    APIDependencies apiDependencies;
    PresenterDependencies presenters;
    ControllerDependencies controllers;

    public DependencySelector(Context applicationContext) {
        apiDependencies = new APIDependencies(applicationContext);
        presenters = new PresenterDependencies();
        controllers = new ControllerDependencies(apiDependencies, presenters);
    }
}
