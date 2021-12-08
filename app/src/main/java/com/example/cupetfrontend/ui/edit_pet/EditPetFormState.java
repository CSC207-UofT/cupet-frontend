package com.example.cupetfrontend.ui.edit_pet;

import com.example.cupetfrontend.ui.form_validators.FormFieldState;

/**
 * A class that stores all the error states for the edit pet form.
 * (i.e. which fields are in an error state)
 */
public class EditPetFormState {
    private FormFieldState nameState;
    private FormFieldState ageState;
    private FormFieldState breedState;
    private FormFieldState biographyState;

    public EditPetFormState() {
        nameState = new FormFieldState();
        ageState = new FormFieldState();
        breedState = new FormFieldState();
        biographyState = new FormFieldState();
    }

    public FormFieldState getNameState() {
        return nameState;
    }

    public FormFieldState getAgeState() {
        return ageState;
    }

    public FormFieldState getBreedState() {
        return breedState;
    }

    public FormFieldState getBiographyState() {
        return biographyState;
    }

    public void setNameState(FormFieldState nameState) {
        this.nameState = nameState;
    }

    public void setAgeState(FormFieldState ageState) {
        this.ageState = ageState;
    }

    public void setBreedState(FormFieldState breedState) {
        this.breedState = breedState;
    }

    public void setBiographyState(FormFieldState biographyState) {
        this.biographyState = biographyState;
    }

    public boolean isDataValid() {
        boolean isError = this.nameState.isError() ||
                this.ageState.isError() ||
                this.breedState.isError() ||
                this.biographyState.isError();

        return !isError;
    }

}
