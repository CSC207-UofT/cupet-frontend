package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;

public class FetchUserAccountPresenter implements FetchUserAccountOutputBoundary {
    // TODO: Attach to view model

    @Override
    public void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response) {

    }

    @Override
    public void onFetchUserAccountFailure(FetchUserAccountFailResponseModel response) {

    }
}