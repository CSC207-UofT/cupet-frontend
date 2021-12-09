package com.example.cupetfrontend.use_cases.output_boundaries.user;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.SetUserProfileImageSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * set user profile image request.
 */
public interface SetUserProfileImageOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onSetUserProfileImageSuccess(SetUserProfileImageSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onSetUserProfileImageFailure(DefaultFailureResponseModel response);
}