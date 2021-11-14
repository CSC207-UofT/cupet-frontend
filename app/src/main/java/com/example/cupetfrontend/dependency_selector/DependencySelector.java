package com.example.cupetfrontend.dependency_selector;

import android.content.Context;
import com.example.cupetfrontend.controllers.SessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.drivers.api.JWTParser;

/**
 * This class stores all the dependencies used in the entire
 * Android app (i.e. what specific implementations of controllers,
 * use cases, etc. are we using)
 */
public class DependencySelector {
    private final APIDependencies apiDependencies;
    private final UserPresenterDependencies userPresenters;
    private final PetPresenterDependencies petPresenters;
    private final AuthPresenterDependencies authPresenters;
    private final ISessionManager sessionManager;

    private final ControllerDependencies controllers;

    public DependencySelector(Context applicationContext) {
        apiDependencies = new APIDependencies(applicationContext);
        userPresenters = new UserPresenterDependencies();
        authPresenters = new AuthPresenterDependencies();
        petPresenters = new PetPresenterDependencies();

        controllers = new ControllerDependencies(apiDependencies, userPresenters,
                petPresenters, authPresenters);

        sessionManager = new SessionManager(new JWTParser());
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

    public AuthPresenterDependencies getAuthPresenters() {
        return authPresenters;
    }

    public ISessionManager getSessionManager() {
        return sessionManager;
    }
}
