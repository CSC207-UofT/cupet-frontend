package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface IGetMatchesViewModel {
    /**
     * This method is called when the get successful matches request was successful.
     */
    void onGetMatchesSuccess();

    /**
     * This method is called when the get successful matches request failed.
     *
     * @param message The error message from the response
     */
    void onGetMatchesFailure(String message);
}