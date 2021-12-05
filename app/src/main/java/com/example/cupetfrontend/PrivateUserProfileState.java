package com.example.cupetfrontend;

import androidx.annotation.Nullable;

public class PrivateUserProfileState {
    @Nullable
    private Integer nameError;
    @Nullable
    private Integer ageError;
    @Nullable
    private Integer biographyError;

    private boolean isDataValid;

    @Nullable
    public Integer getNameError() {
        return nameError;
    }

    @Nullable
    public Integer getBiographyError() {
        return biographyError;
    }

    @Nullable
    public Integer getAgeError() {
        return ageError;
    }

    public void setNameError(@Nullable Integer nameError) {
        this.nameError = nameError;
    }

    public void setBiographyError(@Nullable Integer biographyError) {
        this.biographyError = biographyError;
    }

    public void setAgeError(@Nullable Integer ageError) {
        this.ageError = ageError;
    }


    public void setDataValid(boolean dataValid) {
        isDataValid = dataValid;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
