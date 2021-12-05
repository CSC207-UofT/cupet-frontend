package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.data.model.PetModel;

import java.util.List;

public interface IGetPetsViewModel {

    /**
     * This method is called when the get successful matches request was successful.
     * @param pets
     */
    void onGetPetsSuccess(List<PetModel> pets);

    /**
     * This method is called when the get successful matches request failed.
     *
     * @param message The error message from the response
     */
    void onGetPetsFailure(String message);
}
