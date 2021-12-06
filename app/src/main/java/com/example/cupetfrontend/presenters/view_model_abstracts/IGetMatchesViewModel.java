package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.data.model.PetModel;

import java.util.List;

public interface IGetMatchesViewModel {
    /**
     * This method is called when the get matches request was successful.
     *
     * @param matches list of pet's successful matches
     */
    void onGetMatchesSuccess(List<PetModel> matches);

    /**
     * This method is called when the get matches request failed.
     *
     * @param message The error message from the response
     */
    void onGetMatchesFailure(String message);
}
