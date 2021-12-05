package com.example.cupetfrontend.ui.get_matches;

import androidx.annotation.Nullable;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;

import java.util.ArrayList;
import java.util.List;

/**
 * Get Matches result : success or error message.
 */

public class GetMatchesResult {
    private final boolean isError;
    private final String errorMessage;
    //@Nullable
    private final List<PetModel> matches;

    public GetMatchesResult(boolean isError) {
        this.isError = isError;
        this.errorMessage = "error getting Pet Matches";
        matches = null;
    }

    public GetMatchesResult(boolean isError, List<PetModel> matches) {
        this.isError = isError;
        errorMessage = null;
        this.matches = matches;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Nullable
    public List<PetModel> getMatches() {
        return matches;
    }
}
