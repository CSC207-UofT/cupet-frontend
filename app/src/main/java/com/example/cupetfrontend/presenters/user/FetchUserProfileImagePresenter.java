package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserProfileImageSuccessResponseModel;

public class FetchUserProfileImagePresenter implements FetchUserProfileImageOutputBoundary {
    @Override
    public void onFetchUserProfileImageSuccess(UserProfileImageSuccessResponseModel response) {

    }

    @Override
    public void onFetchUserProfileImageFailure(DefaultFailureResponseModel response) {

    }
}
