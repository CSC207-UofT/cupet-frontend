package com.example.cupetfrontend.use_cases.output_boundaries;

import com.example.cupetfrontend.use_cases.response_models.FetchPetProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchPetProfileSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.LoginFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;

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