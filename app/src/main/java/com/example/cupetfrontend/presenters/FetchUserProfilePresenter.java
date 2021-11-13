package com.example.cupetfrontend.presenters;

import com.example.cupetfrontend.use_cases.output_boundaries.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.FetchUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchUserProfileSuccessResponseModel;

public class FetchUserProfilePresenter implements FetchUserProfileOutputBoundary {
    // TODO: Attach to view model

    @Override
    public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {

    }

    @Override
    public void onFetchUserProfileFailure(FetchUserProfileFailResponseModel response) {

    }
}
