package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.UnMatchPetFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.UnMatchPetSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of an
 * un-match pet request.
 */
public interface UnMatchPetOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onUnMatchPetSuccess(UnMatchPetSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onUnMatchPetFailure(UnMatchPetFailureResponseModel response);
}

