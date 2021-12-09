package com.example.cupetfrontend.ui.register;

import com.example.cupetfrontend.ui.form_validators.FormFieldState;

import androidx.annotation.Nullable;

/**
 * A class that stores all the error states for the registration form.
 * (i.e. which fields are in an error state)
 */
public class RegisterFormState {
    private FormFieldState firstNameState;
    private FormFieldState lastNameState;
    private FormFieldState emailState;
    private FormFieldState passwordState;
    private FormFieldState confirmPasswordState;
    private FormFieldState homeAddressState;
    private FormFieldState cityState;

    public RegisterFormState() {
        firstNameState = new FormFieldState();
        lastNameState = new FormFieldState();
        emailState = new FormFieldState();
        passwordState = new FormFieldState();
        confirmPasswordState = new FormFieldState();
        homeAddressState = new FormFieldState();
        cityState = new FormFieldState();
    }

    public FormFieldState getFirstNameState() {
        return firstNameState;
    }

    public FormFieldState getLastNameState() {
        return lastNameState;
    }

    public FormFieldState getEmailState() {
        return emailState;
    }

    public FormFieldState getPasswordState() {
        return passwordState;
    }

    public FormFieldState getConfirmPasswordState() {
        return confirmPasswordState;
    }

    public FormFieldState getHomeAddressState() {
        return homeAddressState;
    }

    public FormFieldState getCityState() {
        return cityState;
    }

    public void setFirstNameState(FormFieldState firstNameState) {
        this.firstNameState = firstNameState;
    }

    public void setLastNameState(FormFieldState lastNameState) {
        this.lastNameState = lastNameState;
    }

    public void setEmailState(FormFieldState emailState) {
        this.emailState = emailState;
    }

    public void setPasswordState(FormFieldState passwordState) {
        this.passwordState = passwordState;
    }

    public void setConfirmPasswordState(FormFieldState confirmPasswordState) {
        this.confirmPasswordState = confirmPasswordState;
    }

    public void setHomeAddressState(FormFieldState homeAddressState) {
        this.homeAddressState = homeAddressState;
    }

    public void setCityState(FormFieldState cityState) {
        this.cityState = cityState;
    }

    public boolean isDataValid() {
        boolean isError = this.firstNameState.isError() ||
                this.lastNameState.isError() ||
                this.emailState.isError() ||
                this.passwordState.isError() ||
                this.confirmPasswordState.isError() ||
                this.homeAddressState.isError() ||
                this.cityState.isError();

        return !isError;
    }
}
