package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserAccountViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserAccountSuccessResponseModel;

public class EditUserAccountPresenter implements EditUserAccountOutputBoundary {
    IEditUserAccountViewModel editUserAccountViewModel;
    public void setEditUserAccountViewModel(IEditUserAccountViewModel editUserAccountViewModel){
        this.editUserAccountViewModel = editUserAccountViewModel;
    }

    @Override
    public void onEditUserAccountSuccess(EditUserAccountSuccessResponseModel response) {

    }

    @Override
    public void onEditUserAccountFailure(DefaultFailureResponseModel response) {

    }
}
