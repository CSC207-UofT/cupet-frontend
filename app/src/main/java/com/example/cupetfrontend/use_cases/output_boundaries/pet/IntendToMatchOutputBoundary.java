package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of an
 * intend-to-match request.
 */
public interface IntendToMatchOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onIntendToMatchSuccess(IntendToMatchSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onIntendToMatchFailure(DefaultFailureResponseModel response);
}
