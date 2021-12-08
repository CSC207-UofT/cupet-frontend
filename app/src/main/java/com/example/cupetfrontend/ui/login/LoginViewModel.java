package com.example.cupetfrontend.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Patterns;

import com.example.cupetfrontend.controllers.abstracts.IAuthController;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.presenters.abstracts.ILoginPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.ILoginViewModel;
import com.example.cupetfrontend.ui.form_validators.FormFieldState;
import com.example.cupetfrontend.ui.form_validators.UserFormValidator;
import com.example.cupetfrontend.ui.register.RegisterFormState;

public class LoginViewModel extends ViewModel implements ILoginViewModel {

    private final MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();

    public IAuthController authController;

    public LoginViewModel(IAuthController authController, ILoginPresenter loginPresenter) {
        this.authController = authController;
        loginPresenter.setLoginViewModel(this);
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
        LoginFormState newFormState = new LoginFormState();
        LoginFormState oldFormState = loginFormState.getValue();

        if (oldFormState == null){
            loginFormState.setValue(newFormState);
            return;
        }

        validateForm(email, password, newFormState, oldFormState);
        checkFormStateInteracted(email, password, newFormState);

        loginFormState.setValue(newFormState);
    }

    private void validateForm(String email, String password,
                              LoginFormState newFormState, LoginFormState oldFormState) {
        newFormState.setEmailState(
                new FormFieldState(
                        oldFormState.getEmailState(),
                        UserFormValidator.validateEmail(email)
                ));
        newFormState.setPasswordState(
                new FormFieldState(
                        oldFormState.getPasswordState(),
                        UserFormValidator.validatePassword(password)
                ));
    }

    private void checkFormStateInteracted (String email, String password, LoginFormState state) {
        if (email != null && !email.equals("")){
            state.getEmailState().onFieldInteracted();
        }
        if (password != null && !password.equals("")){
            state.getPasswordState().onFieldInteracted();
        }
    }

    @Override
    public void onLoginSuccess(String token) {
        LoginResult newLoginResult = new LoginResult(false);
        newLoginResult.setToken(token);

        loginResult.setValue(newLoginResult);
    }

    @Override
    public void onLoginFailure(String message) {
        loginResult.setValue(new LoginResult(true, message));
    }
}