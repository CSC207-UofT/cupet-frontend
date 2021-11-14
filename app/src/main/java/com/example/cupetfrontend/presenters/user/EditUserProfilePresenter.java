package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileSuccessResponseModel;

public class EditUserProfilePresenter implements EditUserProfileOutputBoundary {
    // TODO: Attach to view model

    @Override
    public void onEditUserProfileSuccess(EditUserProfileSuccessResponseModel response) {

    }

    @Override
    public void onEditUserProfileFailure(EditUserProfileFailResponseModel response) {

    }
}
