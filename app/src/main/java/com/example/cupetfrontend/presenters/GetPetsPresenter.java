package com.example.cupetfrontend.presenters;

import com.example.cupetfrontend.use_cases.output_boundaries.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.GetPetsFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.GetPetsSuccessResponseModel;

public class GetPetsPresenter implements GetPetsOutputBoundary {
    // TODO: Attach to view model

    @Override
    public void onGetPetsSuccess(GetPetsSuccessResponseModel response) {

    }

    @Override
    public void onGetPetsFailure(GetPetsFailResponseModel response) {

    }
}
