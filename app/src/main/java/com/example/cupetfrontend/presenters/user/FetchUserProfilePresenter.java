package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;

public class FetchUserProfilePresenter implements FetchUserProfileOutputBoundary {
    // TODO: Attach to view model

    @Override
    public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {

    }

    @Override
    public void onFetchUserProfileFailure(DefaultFailureResponseModel response) {

    }
}
