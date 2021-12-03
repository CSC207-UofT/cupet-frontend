package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.EditPetSuccessResponseModel;

public class EditPetPresenter implements EditPetOutputBoundary {
    @Override
    public void onEditPetSuccess(EditPetSuccessResponseModel response) {

    }

    @Override
    public void onEditPetFailure(DefaultFailureResponseModel response) {

    }
}
