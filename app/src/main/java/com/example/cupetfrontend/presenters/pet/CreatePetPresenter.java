package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.presenters.abstracts.ICreatePetPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.ICreatePetViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;

public class CreatePetPresenter implements ICreatePetPresenter {
    ICreatePetViewModel createPetViewModel;

    public void setCreatePetViewModel(ICreatePetViewModel createPetViewModel) {
        this.createPetViewModel = createPetViewModel;
    }

    /**
     * On the successful creation of a new pet, handover the presented
     * data to the view model.
     *
     * Presentation:
     *  - remove all data as it is not necessary for display
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onCreatePetSuccess(PetCreatorSuccessResponseModel response) {
        createPetViewModel.onCreatePetSuccess();
    }

    /**
     * On the failed creation of a new pet, handover the presented
     * data to the view model.
     *
     * Presentation:
     *  - preserve the response's message to display
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onCreatePetFailure(PetCreatorFailResponseModel response) {
        createPetViewModel.onCreatePetFailure(response.getErrorMessage());
    }
}
