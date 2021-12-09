package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface IUnMatchViewModel {
    /**
     * This method is called when the un-match user request was successful.
     */
    void onCreateUserSuccess();

    /**
     * This method is called when the un-match user request failed.
     *
     * @param message The error message from the response
     */
    void onCreateUserFailure(String message);
}
