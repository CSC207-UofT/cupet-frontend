package com.example.cupetfrontend.use_cases.output_boundaries.user;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * fetch user account request.
 */
public interface FetchUserAccountOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onFetchUserAccountFailure(DefaultFailureResponseModel response);
}
