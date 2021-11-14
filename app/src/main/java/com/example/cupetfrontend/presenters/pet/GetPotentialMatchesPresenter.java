package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesSuccessResponseModel;

public class GetPotentialMatchesPresenter implements GetPotentialMatchesOutputBoundary {
    @Override
    public void onGetPotentialMatchesSuccess(GetPotentialMatchesSuccessResponseModel response) {

    }

    @Override
    public void onGetPotentialMatchesFailure(GetPotentialMatchesFailResponseModel response) {

    }
}
