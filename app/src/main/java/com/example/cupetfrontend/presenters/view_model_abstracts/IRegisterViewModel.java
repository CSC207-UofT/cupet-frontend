package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface IRegisterViewModel {
    /**
     * This method is called when the register/create user request was successful.
     */
    void onCreateUserSuccess();

    /**
     * This method is called when the register/create user request failed.
     *
     * @param message The error message returned in the response
     */
    void onCreateUserFailure(String message);
}
