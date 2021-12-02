package com.example.cupetfrontend.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.ui.login.LoginActivity;
import com.example.cupetfrontend.ui.register.RegisterActivity;

public class SplashActivity extends AppCompatActivity {

    private SplashViewModel splashViewModel;
    private Button signInButton;
    private Button registerButton;

    private void initializeViews(){
        registerButton = findViewById(R.id.register_button);
        signInButton = findViewById(R.id.sign_in_button);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashViewModel = new SplashViewModel();

        initializeViews();

        setUpSignInButtonClickedListener();
        setUpRegisterButtonClickedListener();
    }

    private void setUpRegisterButtonClickedListener() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToRegisterIntent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(moveToRegisterIntent);
            }
        });
    }

    private void setUpSignInButtonClickedListener() {
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSignInIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(moveToSignInIntent);
            }
        });
    }
}
