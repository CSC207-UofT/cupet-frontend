package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.abstracts.ICreateUserPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IRegisterViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorSuccessResponseModel;

public class CreateUserPresenter implements ICreateUserPresenter {
    IRegisterViewModel registerViewModel;

    public void setRegisterViewModel(IRegisterViewModel registerViewModel) {
        this.registerViewModel = registerViewModel;
    }

    /**
     * On the successful creation of a new user, handover the presented
     * data to the view model.
     *
     * Presentation:
     *  - remove all data as it is not necessary for display
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onCreateUserSuccess(UserCreatorSuccessResponseModel response) {
        registerViewModel.onCreateUserSuccess();
    }

    /**
     * On the failed creation of a new user, handover the presented
     * data to the view model.
     *
     * Presentation:
     *  - preserve the response's message to display
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onCreateUserFailure(DefaultFailureResponseModel response) {
        registerViewModel.onCreateUserFailure(response.getErrorMessage());
    }
}
