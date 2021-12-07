package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface IEditUserAccountViewModel {
    /**
     * This method is called when the edit user account request was successful.
     */
    void onEditUserAccountSuccess();

    /**
     * This method is called when the edit user account request failed.
     *
     * @param message The error message from the response
     */
    void onEditUserAccountFailure(String message);
}
