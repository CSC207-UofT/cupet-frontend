package com.example.cupetfrontend;

import androidx.annotation.Nullable;

public class EditUserAccountState {
    @Nullable
    private Integer EmailError;
    @Nullable
    private Integer PasswordError;
    @Nullable
    private Integer firstNameError;
    @Nullable
    private Integer lastNameError;
    @Nullable
    private Integer addressNameError;
    @Nullable
    private Integer cityNameError;


    private boolean isDataValid;

    public EditUserAccountState() {
        this.EmailError = null;
        this.firstNameError = null;
        this.PasswordError = null;
        this.cityNameError = null;
        this.lastNameError = null;
        this.addressNameError = null;

        this.isDataValid = false;
    }

    @Nullable
    public Integer getEmailError() {
        return EmailError;
    }

    @Nullable
    public Integer getPasswordError() {
        return PasswordError;
    }

    @Nullable
    public Integer getFirstNameError() {
        return firstNameError;
    }

    @Nullable
    public Integer getLastNameError() {
        return lastNameError;
    }

    @Nullable
    public Integer getAddressNameError() {
        return addressNameError;
    }

    @Nullable
    public Integer getCityNameError() {
        return cityNameError;
    }


    public void setEmailError(@Nullable Integer EmailError) {
        this.EmailError = EmailError;
    }

    public void setPasswordError(@Nullable Integer PasswordError) {
        this.PasswordError = PasswordError;
    }

    public void setFirstNameError(@Nullable Integer firstNameError) {
        this.firstNameError = firstNameError;
    }

    public void setLastNameError(@Nullable Integer lastNameError) {
        this.lastNameError = lastNameError;
    }

    public void setAddressNameError(@Nullable Integer addressNameError) {
        this.addressNameError = addressNameError;
    }

    public void setCityNameError(@Nullable Integer cityNameError) {
        this.cityNameError = cityNameError;
    }

    public void setDataValid(boolean dataValid) {
        isDataValid = dataValid;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}