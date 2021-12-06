package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.abstracts.IFetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IFetchUserProfileViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;

public class FetchUserProfilePresenter implements IFetchUserProfilePresenter {
    IFetchUserProfileViewModel viewModel;

    @Override
    public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {
        viewModel.onFetchUserProfileSuccess(new UserProfileData(
                response.getFirstName(),
                response.getLastName(),
                response.getEmail(),
                response.getBiography(),
                response.getInstagram(),
                response.getFacebook(),
                response.getPhoneNumber(),
                response.getProfileImgUrl()
        ));
    }

    @Override
    public void onFetchUserProfileFailure(DefaultFailureResponseModel response) {
        viewModel.onFetchUserProfileFailure(response.getErrorMessage());
    }

    @Override
    public void setViewModel(IFetchUserProfileViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
