package com.example.cupetfrontend.ui.register;

import android.content.Intent;
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
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.abstracts.ICreateUserPresenter;
import com.example.cupetfrontend.ui.login.LoginActivity;

import javax.inject.Inject;

/**
 * The activity for the Register page.
 */
public class RegisterActivity extends AppCompatActivity {
    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailField;
    private EditText addressField;
    private EditText passwordField;
    private EditText passwordConfirmField;
    private EditText cityField;
    private Button registerButton;
    private RegisterViewModel registerViewModel;
    @Inject
    public IUserController userController;
    @Inject
    public ICreateUserPresenter createUserPresenter;

    /**
     * Initialize the views of the form into the field instance variables.
     */
    private void initializeViews() {
        // TODO: Replace with binding
        firstNameField = findViewById(R.id.reg_firstName);
        lastNameField = findViewById(R.id.reg_lastName);
        emailField = findViewById(R.id.reg_email);
        addressField = findViewById(R.id.reg_homeAddress);
        passwordField = findViewById(R.id.reg_password);
        passwordConfirmField = findViewById(R.id.reg_password_confirm);
        registerButton = findViewById(R.id.confirm_register_button);
        cityField = findViewById(R.id.reg_city);
    }

    /**
     * If error message is non-null, display the error message on the field.
     *
     * @param field        The field to display the error state in
     * @param errorMessage the error message to display
     */
    private void setFieldError(EditText field, String errorMessage) {
        if (errorMessage != null) {
            field.setError(errorMessage);
        }
    }

    /**
     * Setup views and state on creation of the activity.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ((App) getApplicationContext()).getAppComponent().inject(this);

        registerViewModel = new RegisterViewModel(userController);
        createUserPresenter.setRegisterViewModel(registerViewModel);

        initializeViews();
        setUpObserveRegisterFormState();
        setUpObserveRegisterResult();
        setUpFormEditedListener();
        setUpRegisterButtonClickedListener();
    }

    /**
     * Set up a listener that alerts registerViewModel when the text
     * in the form has changed.
     */
    private void setUpFormEditedListener() {
        TextWatcher listener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Override with empty method
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Override with empty method
            }

            @Override
            public void afterTextChanged(Editable s) {
                RegisterFormData formData = getRegisterFormData();
                registerViewModel.updateFormState(formData);
            }
        };

        firstNameField.addTextChangedListener(listener);
        lastNameField.addTextChangedListener(listener);
        emailField.addTextChangedListener(listener);
        passwordField.addTextChangedListener(listener);
        passwordConfirmField.addTextChangedListener(listener);
        addressField.addTextChangedListener(listener);
        cityField.addTextChangedListener(listener);
    }

    /**
     * Set up a listener that sends a register request when registerButton
     * is clicked.
     */
    private void setUpRegisterButtonClickedListener() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterFormData formData = getRegisterFormData();
                registerViewModel.register(formData);
            }
        });
    }

    /**
     * Return the data entered into the registration form.
     *
     * @return The data entered into the registration form.
     */
    private RegisterFormData getRegisterFormData() {
        RegisterFormData formData = new RegisterFormData();

        formData.setFirstName(firstNameField.getText().toString());
        formData.setLastName(lastNameField.getText().toString());
        formData.setEmail(emailField.getText().toString());
        formData.setPassword(passwordField.getText().toString());
        formData.setConfirmPassword(passwordConfirmField.getText().toString());
        formData.setHomeAddress(addressField.getText().toString());
        formData.setCity(cityField.getText().toString());

        return formData;
    }

    /**
     * Set up this activity as an observer that observes the result of registration.
     * <p>
     * Update the displayed views when the registration result has changed.
     */
    private void setUpObserveRegisterResult() {
        registerViewModel.getRegisterResult().observe(this, new Observer<RegisterResult>() {
            @Override
            public void onChanged(@Nullable RegisterResult registerResult) {
                if (registerResult == null) {
                    return;
                }

                if (registerResult.isError()) {
                    onRegisterFailure(registerResult.getErrorMessage());
                } else {
                    onRegisterSuccess();
                }

                finish();
            }
        });
    }

    /**
     * Set up this activity as an observer that observes the error states of the
     * registration form.
     * <p>
     * Update the fields accordingly to whether or not they have errors.
     */
    private void setUpObserveRegisterFormState() {
        registerViewModel.getRegisterFormState().observe(this, new Observer<RegisterFormState>() {
            @Override
            public void onChanged(@Nullable RegisterFormState registerFormState) {
                if (registerFormState == null) {
                    return;
                }

                setFieldError(firstNameField,
                        registerFormState.getFirstNameState().getErrorMessage());
                setFieldError(lastNameField,
                        registerFormState.getLastNameState().getErrorMessage());
                setFieldError(emailField,
                        registerFormState.getEmailState().getErrorMessage());
                setFieldError(passwordField,
                        registerFormState.getPasswordState().getErrorMessage());
                setFieldError(passwordConfirmField,
                        registerFormState.getConfirmPasswordState().getErrorMessage());
                setFieldError(addressField,
                        registerFormState.getHomeAddressState().getErrorMessage());
                setFieldError(cityField,
                        registerFormState.getCityState().getErrorMessage());

                registerButton.setEnabled(registerFormState.isDataValid());
            }
        });
    }

    /**
     * Display a Registration Success toast message and move to the login view.
     */
    private void onRegisterSuccess() {
        Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();

        Intent moveToLoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(moveToLoginIntent);
    }

    /**
     * Display a Registration failed toast message.
     *
     * @param errorMessage The error message to display
     */
    private void onRegisterFailure(String errorMessage) {
        Toast.makeText(getApplicationContext(), "Registration Failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

}

