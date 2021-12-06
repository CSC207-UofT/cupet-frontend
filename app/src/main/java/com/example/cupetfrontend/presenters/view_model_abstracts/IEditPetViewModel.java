package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface IEditPetViewModel {
    /**
     * This method is called when the edit pet request was successful.
     */
    void onEditPetSuccess();

    /**
     * This method is called when the edit pet request failed.
     *
     * @param message The error message from the response
     */
    void onEditPetFailure(String message);

    void ping(String A);
}
