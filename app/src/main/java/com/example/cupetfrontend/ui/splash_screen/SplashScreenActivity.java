package com.example.cupetfrontend.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.register.*;

public class SplashScreenActivity extends AppCompatActivity {
    private Button logInButton;
    private Button registerButton;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        logInButton = findViewById(R.id.splash_login_btn);
        registerButton = findViewById(R.id.splash_register_btn);
    }

    /**
     * Setup views and state on creation of the activity.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        initializeViews();

        setUpRegisterButtonClickedListener();
        setUpLoginButtonClickedListener();
    }

    /**
     * Set up a listener that sends moves to the register page when registerButton
     * is clicked.
     */
    private void setUpRegisterButtonClickedListener() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent moveToRegister = new Intent(SplashScreenActivity.this, RegisterActivity.class);
                startActivity(moveToRegister);
            }
        });
    }

    /**
     * Set up a listener that sends moves to the login page when logInButton
     * is clicked.
     */
    private void setUpLoginButtonClickedListener() {
        logInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent moveToLoginIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(moveToLoginIntent);
            }
        });
    }
}
