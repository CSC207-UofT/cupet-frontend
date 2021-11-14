package com.example.cupetfrontend;

import androidx.annotation.Nullable;

public class CreatePetState {
    @Nullable
    private Integer nameError;
    @Nullable
    private Integer ageError;
    @Nullable
    private Integer biographyError;
    @Nullable
    private Integer breedError;

    private boolean isDataValid;

    public CreatePetState() {
        this.nameError = null;
        this.ageError = null;
        this.biographyError = null;
        this.breedError = null;
        this.isDataValid = false;
    }

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

    @Nullable
    public Integer getBreedError() {
        return breedError;
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

    public void setBreedError(@Nullable Integer biographyError) {
        this.breedError = breedError;
    }

    public void setDataValid(boolean dataValid) {
        isDataValid = dataValid;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}

