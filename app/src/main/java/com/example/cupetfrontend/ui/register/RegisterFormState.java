package com.example.cupetfrontend.ui.register;

import androidx.annotation.Nullable;

/**
 * A class that stores all the error states for the registration form.
 * (i.e. which fields are in an error state)
 */
public class RegisterFormState {
    @Nullable
    private Integer firstnameError;
    @Nullable
    private Integer lastnameError;
    @Nullable
    private Integer emailError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer confirmPasswordError;
    @Nullable
    private Integer addressError;
    private boolean isDataValid;

    public RegisterFormState() {
        this.firstnameError = null;
        this.lastnameError = null;
        this.emailError = null;
        this.passwordError = null;
        this.addressError = null;
        this.isDataValid = false;
    }

    @Nullable
    public Integer getFirstnameError() {
        return firstnameError;
    }

    @Nullable
    public Integer getLastnameError() {
        return lastnameError;
    }

    @Nullable
    public Integer getEmailError() {
        return emailError;
    }

    @Nullable
    public Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    public Integer getAddressError() {
        return addressError;
    }

    @Nullable
    public Integer getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setFirstnameError(@Nullable Integer firstnameError) {
        this.firstnameError = firstnameError;
    }

    public void setLastnameError(@Nullable Integer lastnameError) {
        this.lastnameError = lastnameError;
    }

    public void setEmailError(@Nullable Integer emailError) {
        this.emailError = emailError;
    }

    public void setPasswordError(@Nullable Integer passwordError) {
        this.passwordError = passwordError;
    }

    public void setConfirmPasswordError(@Nullable Integer confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

    public void setAddressError(@Nullable Integer addressError) {
        this.addressError = addressError;
    }

    public void setDataValid(boolean dataValid) {
        isDataValid = dataValid;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
