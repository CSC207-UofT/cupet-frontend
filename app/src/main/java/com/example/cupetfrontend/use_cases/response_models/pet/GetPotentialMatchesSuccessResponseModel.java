package com.example.cupetfrontend.use_cases.response_models.pet;

import com.example.cupetfrontend.use_cases.response_models.PetData;

import java.util.List;

public class GetPotentialMatchesSuccessResponseModel {
    private final List<PetData> potentialMatches;

    public GetPotentialMatchesSuccessResponseModel(List<PetData> potentialMatches) {
        this.potentialMatches = potentialMatches;
    }

    public List<PetData> getPotentialMatches() {
        return potentialMatches;
    }
}
