package com.example.cupetfrontend.use_cases.output_boundaries.user;

import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * fetch user profile request.
 */
public interface FetchUserProfileOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onFetchUserProfileFailure(FetchUserProfileFailResponseModel response);
}
