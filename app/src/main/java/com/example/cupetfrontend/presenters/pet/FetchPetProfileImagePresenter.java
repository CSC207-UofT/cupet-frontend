package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetProfileImageSuccessResponseModel;

public class FetchPetProfileImagePresenter implements FetchPetProfileImageOutputBoundary {
    @Override
    public void onFetchPetProfileImageSuccess(PetProfileImageSuccessResponseModel response) {

    }

    @Override
    public void onFetchPetProfileImageFailure(DefaultFailureResponseModel response) {

    }
}
