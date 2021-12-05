package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.data.model.PetModel;

import java.util.List;

public interface IGetPetsViewModel {

    /**
     * This method is called when the get user's pets request was successful.
     * @param pets list of user's registered pets
     */
    void onGetPetsSuccess(List<PetModel> pets);

    /**
     * This method is called when the get user's pets request failed.
     *
     * @param message The error message from the response
     */
    void onGetPetsFailure(String message);
}
