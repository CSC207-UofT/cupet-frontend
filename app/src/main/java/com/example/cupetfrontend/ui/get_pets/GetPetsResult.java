package com.example.cupetfrontend.ui.get_pets;

import androidx.annotation.Nullable;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;

import java.util.ArrayList;
import java.util.List;

/**
 * Get Matches result : success or error message.
 */

public class GetPetsResult {
    private final boolean isError;
    private final String errorMessage;
    //@Nullable
    private final List<PetModel> userPets;

    public GetPetsResult(boolean isError) {
        this.isError = isError;
        this.errorMessage = "error getting user's pets";
        userPets = null;
    }

    public GetPetsResult(boolean isError, List<PetModel> userPets) {
        this.isError = isError;
        errorMessage = null;
        this.userPets = userPets;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Nullable
    public List<PetModel> getPets() {
        return userPets;
    }
}
