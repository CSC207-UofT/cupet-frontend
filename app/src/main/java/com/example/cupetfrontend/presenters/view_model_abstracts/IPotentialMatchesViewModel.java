package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.pet.PresentedPetData;

import java.util.List;

public interface IPotentialMatchesViewModel {
    /**
     * This method is called when the get potential matches request was successful.
     */
    void onGetPotentialMatchesSuccess(List<PresentedPetData> potentialMatches);

    /**
     * This method is called when the get potential matches request failed.
     *
     * @param message The error message from the response
     */
    void onGetPotentialMatchesFailure(String message);
}
