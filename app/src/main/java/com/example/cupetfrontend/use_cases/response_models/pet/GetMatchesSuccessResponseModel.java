package com.example.cupetfrontend.use_cases.response_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetData;

import java.util.List;

public class GetMatchesSuccessResponseModel {
    private final List<PetData> matches;

    public GetMatchesSuccessResponseModel(List<PetData> matches) {
        this.matches = matches;
    }

    public List<PetData> getMatches() {
        return matches;
    }
}
