package com.example.cupetfrontend.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Patterns;

import com.example.cupetfrontend.controllers.abstracts.IAuthController;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.data.LoginRepository;
import com.example.cupetfrontend.presenters.view_model_abstracts.ILoginViewModel;

public class LoginViewModel extends ViewModel implements ILoginViewModel {

    private final MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private final IAuthController authController;

    LoginViewModel(IAuthController authController) {
        this.authController = authController;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String email, String password) {
        authController.login(email, password);
    }

    public void loginDataChanged(String email, String password) {
        if (!isEmailValid(email)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_email, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    private boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        if (email.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        } else {
            return !email.trim().isEmpty();
        }
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    @Override
    public void onLoginSuccess(String token) {
        LoginResult newLoginResult = new LoginResult(false);
        newLoginResult.setToken(token);

        // TODO: Remove after demo
        System.out.println("Login success with token: " + token);
        System.out.println("Login success with user id: " + token);

        loginResult.setValue(newLoginResult);
    }

    @Override
    public void onLoginFailure(String message) {
        loginResult.setValue(new LoginResult(true, message));
    }
}