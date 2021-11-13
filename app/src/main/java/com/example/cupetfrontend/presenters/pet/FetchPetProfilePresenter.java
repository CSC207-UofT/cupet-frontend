package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileSuccessResponseModel;

public class FetchPetProfilePresenter implements FetchPetProfileOutputBoundary {
    @Override
    public void onFetchPetProfileSuccess(FetchPetProfileSuccessResponseModel response) {

    }

    @Override
    public void onFetchPetProfileFailure(FetchPetProfileFailResponseModel response) {

    }
}
