package com.example.cupetfrontend.use_cases.output_boundaries.user;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * create user request.
 */
public interface UserCreatorOutputBoundary {
    /**
     * Method called when a successful response is received.
     * @param response The response data
     */
    void onCreateUserSuccess(UserCreatorSuccessResponseModel response);
    /**
     * Method called when a failed response is received.
     * @param response The response data
     */
    void onCreateUserFailure(DefaultFailureResponseModel response);
}
