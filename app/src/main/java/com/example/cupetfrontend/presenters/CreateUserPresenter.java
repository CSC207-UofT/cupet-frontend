package com.example.cupetfrontend.presenters;

import com.example.cupetfrontend.ui.login.register2.IRegisterViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.UserCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.UserCreatorSuccessResponseModel;

public class CreateUserPresenter implements UserCreatorOutputBoundary {
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
    public void onCreateUserFailure(UserCreatorFailResponseModel response) {
        registerViewModel.onCreateUserFailure(response.getMessage());
    }
}
