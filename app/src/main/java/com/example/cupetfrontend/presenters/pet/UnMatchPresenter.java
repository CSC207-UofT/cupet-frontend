package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.UnMatchPetOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.UnMatchPetSuccessResponseModel;

public class UnMatchPresenter implements UnMatchPetOutputBoundary {
    @Override
    public void onUnMatchPetSuccess(UnMatchPetSuccessResponseModel response) {

    }

    @Override
    public void onUnMatchPetFailure(DefaultFailureResponseModel response) {

    }
}
