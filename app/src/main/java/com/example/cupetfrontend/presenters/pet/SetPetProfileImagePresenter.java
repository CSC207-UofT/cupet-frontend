package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.SetPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.SetPetProfileImageSuccessResponseModel;

public class SetPetProfileImagePresenter implements SetPetProfileImageOutputBoundary {
    @Override
    public void onSetPetProfileImageSuccess(SetPetProfileImageSuccessResponseModel response) {

    }

    @Override
    public void onSetPetProfileImageFailure(DefaultFailureResponseModel response) {

    }
}
