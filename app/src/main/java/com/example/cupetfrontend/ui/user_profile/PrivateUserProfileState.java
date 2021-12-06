package com.example.cupetfrontend.ui.user_profile;

import androidx.annotation.Nullable;

public class PrivateUserProfileState {
    @Nullable
    private Integer biographyError;

    private boolean isDataValid;

    @Nullable
    public Integer getBiographyError() {
        return biographyError;
    }

    public void setBiographyError(@Nullable Integer biographyError) {
        this.biographyError = biographyError;
    }


    public void setDataValid(boolean dataValid) {
        isDataValid = dataValid;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
