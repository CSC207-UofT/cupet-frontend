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
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.dependency_selector.DependencySelector;
import com.example.cupetfrontend.ui.register.RegisterActivity;

/**
 * The activity for the login page.
 */
public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private Button loginButton;
    private EditText emailField;
    private EditText passwordField;

    private void initializeViews(){
        loginButton = findViewById(R.id.login_button);
        emailField = findViewById(R.id.login_email);
        passwordField = findViewById(R.id.login_password);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new LoginViewModelFactory().createLoginViewModel(this.getApplication());
        DependencySelector dependencySelector = ((App) this.getApplication()).getDependencySelector();
        dependencySelector.getAuthPresenters().getLoginPresenter().setLoginViewModel(loginViewModel);

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

                // Complete and destroy login activity once successful
//                finish();
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
        System.out.println("Successful login with token " + token);

        DependencySelector dependencySelector = ((App) this.getApplication()).getDependencySelector();
        ISessionManager sessionManager = dependencySelector.getSessionManager();

        // TODO: Move the set token call into use cases through dependency injection
        try {
            sessionManager.setToken(token);
            System.out.println("Successful login with user " + sessionManager.getUserId());
        } catch (InvalidJWTException e) {
            e.printStackTrace();
        }

        // TODO: Direct to new view
//        Intent moveToLoginIntent = new Intent(LoginActivity.this, LoginActivity.class);
//        startActivity(moveToLoginIntent);
    }

    private void onLoginFailure(String errorMessage) {
        System.out.println("Login failed");
        Toast.makeText(getApplicationContext(), "Login failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }
}