package com.example.cupetfrontend.ui.edit_account;

import com.example.cupetfrontend.ui.form_validators.FormFieldState;

public class EditUserAccountFormState {
    private FormFieldState firstNameState;
    private FormFieldState lastNameState;
    private FormFieldState emailState;
    private FormFieldState passwordState;
    private FormFieldState confirmPasswordState;
    private FormFieldState homeAddressState;
    private FormFieldState cityState;

    public EditUserAccountFormState() {
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

    public boolean isDataValid(){
        boolean isError = firstNameState.isError() || lastNameState.isError() ||
                emailState.isError() || passwordState.isError() || confirmPasswordState.isError()
                || homeAddressState.isError() || cityState.isError();

        return !isError;
    }
}