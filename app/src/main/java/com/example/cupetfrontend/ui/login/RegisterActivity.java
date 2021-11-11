package com.example.cupetfrontend.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.Observer;
import com.example.cupetfrontend.App;
import com.example.cupetfrontend.R;
import com.example.cupetfrontend.RegisterData;
import com.example.cupetfrontend.controllers.abstracts.IUserController;

public class RegisterActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    EditText address;
    EditText password;
    EditText password_confirm;
    Button confirm_registerButton;
    RegisterViewModel registerViewModel;
    boolean is_valid = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        IUserController userController = ((App) getApplication()).getDependencySelector().
                getControllers().getUserController();
        registerViewModel = new RegisterViewModel(userController);

        firstName = findViewById(R.id.reg_firstName);
        lastName = findViewById(R.id.reg_lastName);
        email = findViewById(R.id.reg_email);
        address = findViewById(R.id.reg_homeAddress);
        password = findViewById(R.id.reg_password);
        password_confirm = findViewById(R.id.reg_password_confirm);
        confirm_registerButton = findViewById(R.id.confirm_register_button);

        registerViewModel.getRegisterFormState().observe(this, new Observer<RegisterFormState>() {
            @Override
            public void onChanged(@Nullable RegisterFormState registerFormState) {
                if (registerFormState == null) {
                    return;
                }
                confirm_registerButton.setEnabled(registerFormState.isDataValid());
                // TODO: Set error text for each of the fields
//                if (loginFormState.getUsernameError() != null) {
//                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
//                }
//                if (loginFormState.getPasswordError() != null) {
//                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
//                }
            }
        });

        registerViewModel.getRegisterResult().observe(this, new Observer<RegisterResult>() {
            @Override
            public void onChanged(@Nullable RegisterResult registerResult) {
                // TODO: Show the result of the registration.
//                if (loginResult == null) {
//                    return;
//                }
//                loadingProgressBar.setVisibility(View.GONE);
//                if (loginResult.getError() != null) {
//                    showLoginFailed(loginResult.getError());
//                }
//                if (loginResult.getSuccess() != null) {
//                    updateUiWithUser(loginResult.getSuccess());
//                }
//                setResult(Activity.RESULT_OK); //if success result is ok - replace result_ok

                //Complete and destroy login activity once successful
                finish();
                //TODO: Direct to some view after registered
            }
        });

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
                // TODO: The ordering of firstName, lastName, address, password, email
                //  is super weird and was brought over from the back-end.
                //  Going to change this everywhere - Andrew.
                //  It should probably be firstName, lastName, email, password, address
                registerViewModel.registerDataChanged(
                        firstName.getText().toString(), lastName.getText().toString(), address.getText().toString(), password.getText().toString(), email.getText().toString());
            }
        };

        confirm_registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                registerViewModel.register(firstName.getText().toString(), lastName.getText().toString(), address.getText().toString(), password.getText().toString(), email.getText().toString());
            }
        });

    }
}


    // Potentially Create ViewModel for Register

