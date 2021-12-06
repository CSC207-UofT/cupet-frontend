package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.abstracts.IEditUserProfilePresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileSuccessResponseModel;

public class EditUserProfilePresenter implements IEditUserProfilePresenter {
    IEditUserProfileViewModel editUserProfileViewModel;

    @Override
    public void onEditUserProfileSuccess(EditUserProfileSuccessResponseModel response) {
        editUserProfileViewModel.onEditUserProfileSuccess();
    }

    @Override
    public void onEditUserProfileFailure(DefaultFailureResponseModel response) {
        editUserProfileViewModel.onEditUserProfileFailure(response.getErrorMessage());
    }

    @Override
    public void setEditUserProfileViewModel(IEditUserProfileViewModel editUserProfileViewModel) {
        this.editUserProfileViewModel = editUserProfileViewModel;
    }
}
