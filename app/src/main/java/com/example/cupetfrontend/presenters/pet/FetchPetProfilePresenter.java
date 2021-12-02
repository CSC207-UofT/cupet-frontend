package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.presenters.abstracts.IFetchPetProfilePresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPetProfileViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileFailResponseModel;

import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileSuccessResponseModel;

public class FetchPetProfilePresenter implements IFetchPetProfilePresenter {
    IPetProfileViewModel petProfileViewModel;

    @Override
    public void setPetProfileViewModel(IPetProfileViewModel petProfileViewModel) {
        this.petProfileViewModel = petProfileViewModel;
    }

    @Override
    public void onFetchPetProfileSuccess(FetchPetProfileSuccessResponseModel response) {
        petProfileViewModel.onFetchPetSuccess();
    }

    @Override

    public void onFetchPetProfileFailure(FetchPetProfileFailResponseModel response) {
        petProfileViewModel.onFetchPetFailure(response.getErrorMessage());
    }

}
