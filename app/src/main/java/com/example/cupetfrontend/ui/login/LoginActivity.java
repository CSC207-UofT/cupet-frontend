package com.example.cupetfrontend.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.se.omapi.Session;
import androidx.lifecycle.Observer;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.InvalidJWTException;
import com.example.cupetfrontend.controllers.abstracts.IAuthController;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.presenters.abstracts.ILoginPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IViewMyPetsViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.ViewMyPetsContext;
import com.example.cupetfrontend.ui.MainActivity;
import com.example.cupetfrontend.ui.register.RegisterActivity;

import javax.inject.Inject;

/**
 * The activity for the login page.
 */
public class LoginActivity extends AppCompatActivity {

    public LoginViewModel loginViewModel;
    private Button loginButton;
    private EditText emailField;
    private EditText passwordField;
    @Inject
    public ISessionManager sessionManager;
    @Inject
    public IAuthController authController;
    @Inject
    public ILoginPresenter loginPresenter;
    @Inject
    public IViewMyPetsViewModel viewMyPetsViewModel;

    private void initializeViews(){
        loginButton = findViewById(R.id.login_button);
        emailField = findViewById(R.id.login_email);
        passwordField = findViewById(R.id.login_password);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getAppComponent().inject(this);
        loginViewModel = new LoginViewModel(authController, loginPresenter);

        initializeViews();
        setUpObserveLoginFormState();
        setUpObserveLoginResult();
        setUpFormEditedListener();
        setUpLoginButtonClickedListener();
    }

    private void setUpLoginButtonClickedListener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(emailField.getText().toString(),
                        passwordField.getText().toString());
            }
        });
    }

    private void setUpFormEditedListener() {
        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(emailField.getText().toString(),
                        passwordField.getText().toString());
            }
        };

        emailField.addTextChangedListener(afterTextChangedListener);
        passwordField.addTextChangedListener(afterTextChangedListener);
    }

    private void setUpObserveLoginResult() {
        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }

                if (loginResult.isError()){
                    onLoginFailure(loginResult.getErrorMessage());
                }else{
                    onLoginSuccess(loginResult.getToken());
                }
            }
        });
    }

    private void setUpObserveLoginFormState() {
        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getEmailError() != null) {
                    emailField.setError(getString(loginFormState.getEmailError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordField.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });
    }

    private void onLoginSuccess(String token) {
        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
        sessionManager.setToken(token);

        Intent moveToMainActivity = new Intent(LoginActivity.this, MainActivity.class);
        viewMyPetsViewModel.setContext(new ViewMyPetsContext(true));
        startActivity(moveToMainActivity);
    }

    private void onLoginFailure(String errorMessage) {
        Toast.makeText(getApplicationContext(), "Login Failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}