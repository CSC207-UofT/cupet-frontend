package com.example.cupetfrontend.ui.potential_matches;

import com.example.cupetfrontend.presenters.pet.PresentedPetData;

import java.util.List;

/**
 * A class representing the result of a get potential matches request
 */
public class GetPotentialMatchesResult {
    private final boolean isError;
    private final String errorMessage;
    private final List<PresentedPetData> potentialMatches;

    public GetPotentialMatchesResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
        this.potentialMatches = null;
    }

    public GetPotentialMatchesResult(List<PresentedPetData> potentialMatches){
        this.isError = false;
        this.errorMessage = null;
        this.potentialMatches = potentialMatches;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<PresentedPetData> getPotentialMatches() {
        return potentialMatches;
    }
}
