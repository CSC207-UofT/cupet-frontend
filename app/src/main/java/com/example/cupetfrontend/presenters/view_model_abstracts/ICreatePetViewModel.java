package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface ICreatePetViewModel {
    /**
     * This method is called when the create pet request was successful.
     */
    void onCreatePetSuccess(String petId);

    /**
     * This method is called when the create pet request failed.
     *
     * @param message The error message from the response
     */
    void onCreatePetFailure(String message);

}
