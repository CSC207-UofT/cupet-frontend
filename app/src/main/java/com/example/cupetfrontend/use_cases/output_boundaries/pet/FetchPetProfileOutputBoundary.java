package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * fetch pet profile request.
 */
public interface FetchPetProfileOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onFetchPetProfileSuccess(FetchPetProfileSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onFetchPetProfileFailure(FetchPetProfileFailResponseModel response);
}