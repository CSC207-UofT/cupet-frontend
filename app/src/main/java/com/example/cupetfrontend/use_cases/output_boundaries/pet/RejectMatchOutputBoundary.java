package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RejectMatchSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * create pet request.
 */
public interface RejectMatchOutputBoundary {
    /**
     * Method called when a successful response is received.
     * @param response The response data
     */
    void onRejectMatchSuccess(RejectMatchSuccessResponseModel response);
    /**
     * Method called when a failed response is received.
     * @param response The response data
     */
    void onRejectMatchFailure(DefaultFailureResponseModel response);
}
