package com.example.cupetfrontend.use_cases.output_boundaries;

import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * login request.
 */
public interface LoginOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onLoginSuccess(LoginSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onLoginFailure(DefaultFailureResponseModel response);
}
