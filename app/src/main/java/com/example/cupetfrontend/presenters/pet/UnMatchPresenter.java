package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.presenters.abstracts.IUnMatchPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUnMatchViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.UnMatchPetOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.UnMatchPetSuccessResponseModel;

public class UnMatchPresenter implements IUnMatchPresenter {
    private IUnMatchViewModel viewModel;

    @Override
    public void setUnMatchViewModel(IUnMatchViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onUnMatchPetSuccess(UnMatchPetSuccessResponseModel response) {
        viewModel.onCreateUserSuccess();
    }

    @Override
    public void onUnMatchPetFailure(DefaultFailureResponseModel response) {
        viewModel.onCreateUserFailure(response.getErrorMessage());
    }
}
