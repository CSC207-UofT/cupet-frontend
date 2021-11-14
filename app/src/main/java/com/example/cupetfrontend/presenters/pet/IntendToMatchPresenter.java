package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.IntendToMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchSuccessResponseModel;

public class IntendToMatchPresenter implements IntendToMatchOutputBoundary {
    @Override
    public void onIntendToMatchSuccess(IntendToMatchSuccessResponseModel response) {

    }

    @Override
    public void onIntendToMatchFailure(IntendToMatchFailResponseModel response) {

    }
}
