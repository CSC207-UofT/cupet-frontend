package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.RejectMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RejectMatchSuccessResponseModel;

public class RejectMatchPresenter implements RejectMatchOutputBoundary {
    @Override
    public void onRejectMatchSuccess(RejectMatchSuccessResponseModel response) {

    }

    @Override
    public void onRejectMatchFailure(DefaultFailureResponseModel response) {

    }
}
