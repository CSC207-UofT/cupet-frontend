package com.example.cupetfrontend.dagger_dependencies;

import com.example.cupetfrontend.dagger_dependencies.modules.ControllersModule;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.login.LoginViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * The main Dagger component for the application.
 */
@Singleton
@Component(modules = {ControllersModule.class})
public interface AppComponent {
    void inject(LoginViewModel loginViewModel);
    void inject(LoginActivity loginActivity);
}
