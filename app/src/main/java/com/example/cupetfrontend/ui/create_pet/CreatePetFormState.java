package com.example.cupetfrontend.ui.create_pet;

import androidx.annotation.Nullable;

/**
 * A class that stores all the error states for the create pet form.
 * (i.e. which fields are in an error state)
 */
public class CreatePetFormState {
    @Nullable
    private Integer petNameError;
    @Nullable
    private Integer petAgeError;
    @Nullable
    private Integer petBreedError;
    @Nullable
    private Integer petBioError;

    private boolean isDataValid;

    public CreatePetFormState() {
        this.petNameError = null;
        this.petAgeError = null;
        this.petBreedError = null;
        this.petBioError = null;
        this.isDataValid = false;
    }

    @Nullable
    public Integer getPetNameError() {
        return petNameError;
    }

    @Nullable
    public Integer getPetAgeError() {
        return petAgeError;
    }

    @Nullable
    public Integer getPetBreedError() {
        return petBreedError;
    }

    @Nullable
    public Integer getPetBioError() {
        return petBioError;
    }

    public void setPetNameError(@Nullable Integer petNameError) {
        this.petNameError = petNameError;
    }

    public void setPetAgeError(@Nullable Integer petAgeError) {
        this.petAgeError = petAgeError;
    }

    public void setPetBreedError(@Nullable Integer petBreedError) {
        this.petBreedError = petBreedError;
    }

    public void setPetBioError(@Nullable Integer petBioError) {
        this.petBioError = petBioError;
    }

    public void setDataValid(boolean dataValid) {
        isDataValid = dataValid;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
