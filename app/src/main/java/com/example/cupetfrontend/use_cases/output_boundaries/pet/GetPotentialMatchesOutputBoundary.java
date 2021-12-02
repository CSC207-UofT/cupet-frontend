package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * get potential matches request.
 */
public interface GetPotentialMatchesOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onGetPotentialMatchesSuccess(GetPotentialMatchesSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onGetPotentialMatchesFailure(DefaultFailureResponseModel response);
}
