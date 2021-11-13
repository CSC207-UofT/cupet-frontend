package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;

public class GetMatchesPresenter implements GetMatchesOutputBoundary {
    @Override
    public void onGetMatchesSuccess(GetMatchesSuccessResponseModel response) {

    }

    @Override
    public void onGetMatchesFailure(GetMatchesFailResponseModel response) {

    }
}
