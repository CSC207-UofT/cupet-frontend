package com.example.cupetfrontend.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the register form.
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
    private Integer addressError;
    private boolean isDataValid;

    RegisterFormState(@Nullable Integer firstnameError, @Nullable Integer lastnameError,
                      @Nullable Integer emailError, @Nullable Integer passwordError, @Nullable Integer addressError) {
        this.firstnameError = firstnameError;
        this.lastnameError = lastnameError;
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.addressError = addressError;
        this.isDataValid = false;

    }

    RegisterFormState(boolean isDataValid) {
        this.firstnameError = null;
        this.lastnameError = null;
        this.emailError = null;
        this.passwordError = null;
        this.addressError = null;
        this.isDataValid = isDataValid;
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

    public boolean isDataValid() {
        return isDataValid;
    }
}
