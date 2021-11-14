package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.presenters.abstracts.ICreatePetPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.ICreaterPetViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;

public class CreatePetPresenter implements ICreatePetPresenter {
    ICreaterPetViewModel creatorPetViewModel;


    @Override
    public void onCreatePetSuccess(PetCreatorSuccessResponseModel response) {

    }

    @Override
    public void onCreatePetFailure(PetCreatorFailResponseModel response) {

    }

    @Override
    public void setCreatePetViewModel(ICreaterPetViewModel creatorPetViewModel) {
        this.creatorPetViewModel = creatorPetViewModel;
    }
}
