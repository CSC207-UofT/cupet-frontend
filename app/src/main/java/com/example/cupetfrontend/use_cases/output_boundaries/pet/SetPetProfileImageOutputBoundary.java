package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.SetPetProfileImageSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * set pet profile image request.
 */
public interface SetPetProfileImageOutputBoundary {
    /**
     * Method called when a successful response is received.
     * @param response The response data
     */
    void onSetPetProfileImageSuccess(SetPetProfileImageSuccessResponseModel response);
    /**
     * Method called when a failed response is received.
     * @param response The response data
     */
    void onSetPetProfileImageFailure(DefaultFailureResponseModel response);
}
