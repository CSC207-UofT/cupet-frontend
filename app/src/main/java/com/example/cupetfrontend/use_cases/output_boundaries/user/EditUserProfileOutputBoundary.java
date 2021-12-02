package com.example.cupetfrontend.use_cases.output_boundaries.user;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * edit user profile request.
 */
public interface EditUserProfileOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onEditUserProfileSuccess(EditUserProfileSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onEditUserProfileFailure(DefaultFailureResponseModel response);
}
