package com.example.cupetfrontend.ui.matched_pet_profile;

import com.example.cupetfrontend.data.model.PetModel;

public class MatchedPetProfileResult {
    private final boolean isError;
    private final String errorMessage;
    private PetModel petModel;

    public MatchedPetProfileResult(boolean isError, String errorMessage){
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    /**
     * Initialize a successful matched pet profile result
     */
    public MatchedPetProfileResult(PetModel petModel){
        this.isError = false;
        this.errorMessage = null;
        this.petModel = petModel;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public PetModel getPetModel() {
        return this.petModel;
    }
}
