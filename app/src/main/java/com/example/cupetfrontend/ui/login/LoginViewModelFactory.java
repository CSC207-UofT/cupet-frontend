package com.example.cupetfrontend.ui.login;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.controllers.abstracts.IAuthController;
import com.example.cupetfrontend.data.LoginDataSource;
import com.example.cupetfrontend.data.LoginRepository;

/**
 * A LoginViewModel factory responsible for creating a LoginViewModel.
 */
public class LoginViewModelFactory {
    public LoginViewModel createLoginViewModel(Application application){
        IAuthController authController = ((App) application).getDependencySelector().
                getControllers().getAuthController();

        return new LoginViewModel(authController);
    }
}