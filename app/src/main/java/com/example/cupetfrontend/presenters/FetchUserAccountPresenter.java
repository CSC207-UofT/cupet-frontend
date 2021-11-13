package com.example.cupetfrontend.presenters;

import com.example.cupetfrontend.use_cases.output_boundaries.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.FetchUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchUserAccountSuccessResponseModel;

public class FetchUserAccountPresenter implements FetchUserAccountOutputBoundary {
    // TODO: Attach to view model

    @Override
    public void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response) {

    }

    @Override
    public void onFetchUserAccountFailure(FetchUserAccountFailResponseModel response) {

    }
}
