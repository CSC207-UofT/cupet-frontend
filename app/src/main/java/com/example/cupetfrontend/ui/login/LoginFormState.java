package com.example.cupetfrontend.ui.login;

import com.example.cupetfrontend.ui.form_validators.FormFieldState;

/**
 * Data validation state of the login form.
 */
class LoginFormState {
    private FormFieldState emailState;
    private FormFieldState passwordState;

    public LoginFormState() {
        emailState = new FormFieldState();
        passwordState = new FormFieldState();
    }

    public FormFieldState getEmailState() {
        return emailState;
    }

    public FormFieldState getPasswordState() {
        return passwordState;
    }

    public void setEmailState(FormFieldState emailState) {
        this.emailState = emailState;
    }

    public void setPasswordState(FormFieldState passwordState) {
        this.passwordState = passwordState;
    }

    public boolean isDataValid() {
        boolean isError = this.emailState.isError() ||
                this.passwordState.isError();

        return !isError;
    }
}