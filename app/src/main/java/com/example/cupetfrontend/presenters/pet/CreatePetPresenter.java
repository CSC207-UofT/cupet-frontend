package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;

public class CreatePetPresenter implements PetCreatorOutputBoundary {
    @Override
    public void onCreatePetSuccess(PetCreatorSuccessResponseModel response) {

    }

    @Override
    public void onCreatePetFailure(PetCreatorFailResponseModel response) {

    }
}
