package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.abstracts.IFetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.abstracts.IPrivateProfilePresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IFetchUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPrivateUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;

public class FetchUserProfilePresenter implements IFetchUserProfilePresenter, IPrivateProfilePresenter {

    IPrivateUserProfileViewModel privateUserProfileViewModel;
    IFetchUserProfileViewModel fetchUserProfileViewModel;
    @Override
    public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {
        String image_url = "https://soccerpointeclaire.com/wp-content/uploads/2021/06/default-profile-pic-e1513291410505.jpg"; //Todo: Fix THIS ASAP
        privateUserProfileViewModel.onPrivateProfileSuccess(response.getFirstName(), response.getFirstName(), response.getBiography(), image_url);
    }

    @Override
    public void onFetchUserProfileFailure(DefaultFailureResponseModel response) {

    }

    @Override
    public void setFetchUserProfileViewModel(IFetchUserProfileViewModel fetchUserProfileViewModel) {
        this.fetchUserProfileViewModel =fetchUserProfileViewModel;
    }

    @Override
    public void setPrivateProfileViewModel(IPrivateUserProfileViewModel privateProfileViewModel) {
        this.privateUserProfileViewModel = privateUserProfileViewModel;
    }
}
