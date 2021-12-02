package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.presenters.abstracts.IEditPetPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditPetViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;

import com.example.cupetfrontend.use_cases.response_models.pet.EditPetSuccessResponseModel;

public class EditPetPresenter implements IEditPetPresenter {
    IEditPetViewModel editPetViewModel;

    @Override
    public void setEditPetViewModel(IEditPetViewModel editPetViewModel) {
        this.editPetViewModel = editPetViewModel;
    }

    /**
     * On the successful edition of a pet, handover the presented
     * data to the view model.
     *
     * Presentation:
     *  - remove all data as it is not necessary for display
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onEditPetSuccess(EditPetSuccessResponseModel response) {
        editPetViewModel.onEditPetSuccess();
    }

    /**
     * On the failed edition of a pet, handover the presented
     * data to the view model.
     *
     * Presentation:
     *  - preserve the response's message to display
     *
     * @param response The response from the use case's layer
     */
    @Override

    public void onEditPetFailure(DefaultFailureResponseModel response) {
        editPetViewModel.onEditPetFailure(response.getErrorMessage());


    }
}
