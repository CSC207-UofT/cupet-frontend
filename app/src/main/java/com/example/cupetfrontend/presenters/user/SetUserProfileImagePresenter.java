package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.use_cases.output_boundaries.user.SetUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.SetUserProfileImageSuccessResponseModel;

public class SetUserProfileImagePresenter implements SetUserProfileImageOutputBoundary {
    @Override
    public void onSetUserProfileImageSuccess(SetUserProfileImageSuccessResponseModel response) {

    }

    @Override
    public void onSetUserProfileImageFailure(DefaultFailureResponseModel response) {

    }
}
