package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.abstracts.ISetUserProfileImagePresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.SetUserProfileImageSuccessResponseModel;

public class SetUserProfileImagePresenter implements ISetUserProfileImagePresenter {
    private IEditUserProfileViewModel viewModel;

    @Override
    public void onSetUserProfileImageSuccess(SetUserProfileImageSuccessResponseModel response) {
        viewModel.onSetUserProfileImageSuccess();
    }

    @Override
    public void onSetUserProfileImageFailure(DefaultFailureResponseModel response) {
        viewModel.onSetUserProfileImageFailure(response.getErrorMessage());
    }

    @Override
    public void setViewModel(IEditUserProfileViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
