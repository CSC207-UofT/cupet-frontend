package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetProfileImageSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * fetch pet profile image request.
 */
public interface FetchPetProfileImageOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onFetchPetProfileImageSuccess(PetProfileImageSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onFetchPetProfileImageFailure(DefaultFailureResponseModel response);
}
