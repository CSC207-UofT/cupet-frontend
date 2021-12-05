package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.GetPetsSuccessResponseModel;

public class GetPetsPresenter implements GetPetsOutputBoundary {
    // TODO: Attach to view model

    @Override
    public void onGetPetsSuccess(GetPetsSuccessResponseModel response) {

    }

    @Override
    public void onGetPetsFailure(DefaultFailureResponseModel response) {

    }
}
