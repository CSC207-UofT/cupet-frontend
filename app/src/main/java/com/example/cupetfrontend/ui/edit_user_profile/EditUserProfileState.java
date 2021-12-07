package com.example.cupetfrontend.ui.edit_user_profile;

import androidx.annotation.Nullable;

public class EditUserProfileState {
    @Nullable
    private Integer biographyError;
    @Nullable
    private Integer FacebookError;
    @Nullable
    private Integer PhoneNumberError;
    @Nullable
    private Integer InstagramError;


    private boolean isDataValid;

    public EditUserProfileState(){
        this.biographyError = null;
        this.FacebookError = null;
        this.isDataValid = false;
        this.PhoneNumberError = null;
        this.InstagramError = null;
    }

    @Nullable
    public Integer getBiographyError(){
        return this.biographyError;
    }

    @Nullable
    public Integer getFacebookError(){
        return this.FacebookError;
    }

    @Nullable
    public Integer getPhoneNumberError(){
        return this.PhoneNumberError;
    }

    @Nullable
    public Integer getInstagramError(){
        return this.InstagramError;
    }

    public void setBiographyError(@Nullable Integer biographyError){
        this.biographyError = biographyError;
    }

    public void setInstagramError(@Nullable Integer instagramError){
        this.InstagramError = instagramError;
    }

    public void setFacebookError(@Nullable Integer facebookError){
        this.FacebookError = facebookError;
    }

    public void setPhoneNumberError(@Nullable Integer phoneNumberError){
        this.PhoneNumberError = phoneNumberError;
    }

    public void setDataValid(boolean dataValid) {
        isDataValid = dataValid;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
