package com.example.cupetfrontend.ui.edit_user_profile;

import com.example.cupetfrontend.ui.form_validators.FormFieldState;

public class EditUserProfileState {
    private FormFieldState biographyState;
    private FormFieldState phoneNumberState;
    private FormFieldState facebookState;
    private FormFieldState instagramState;

    public EditUserProfileState() {
        biographyState = new FormFieldState();
        phoneNumberState = new FormFieldState();
        facebookState = new FormFieldState();
        instagramState = new FormFieldState();
    }

    public FormFieldState getBiographyState() {
        return biographyState;
    }

    public FormFieldState getPhoneNumberState() {
        return phoneNumberState;
    }

    public FormFieldState getFacebookState() {
        return facebookState;
    }

    public FormFieldState getInstagramState() {
        return instagramState;
    }

    public void setBiographyState(FormFieldState biographyState) {
        this.biographyState = biographyState;
    }

    public void setPhoneNumberState(FormFieldState phoneNumberState) {
        this.phoneNumberState = phoneNumberState;
    }

    public void setFacebookState(FormFieldState facebookState) {
        this.facebookState = facebookState;
    }

    public void setInstagramState(FormFieldState instagramState) {
        this.instagramState = instagramState;
    }

    public boolean isDataValid() {
        boolean isError = this.biographyState.isError() ||
                this.phoneNumberState.isError() ||
                this.facebookState.isError() ||
                this.instagramState.isError();

        return !isError;
    }
}
