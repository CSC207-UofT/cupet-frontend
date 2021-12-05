package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.abstracts.IPrivateProfilePresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPrivateUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;

public class FetchUserProfilePresenter implements FetchUserProfileOutputBoundary {

    IPrivateUserProfileViewModel privateUserProfileViewModel;

    public void setPrivateUserProfileViewModel(IPrivateUserProfileViewModel privateUserProfileViewModel){
        this.privateUserProfileViewModel = privateUserProfileViewModel;
    }
    @Override
    public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {
        privateUserProfileViewModel.onPrivateProfileSuccess(response.getFirstName(), response.getFirstName(), response.getBiography());
    }

    @Override
    public void onFetchUserProfileFailure(DefaultFailureResponseModel response) {

    }

}
