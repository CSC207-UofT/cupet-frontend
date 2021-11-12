package com.example.cupetfrontend.use_cases.output_boundaries;

import com.example.cupetfrontend.use_cases.response_models.EditUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserProfileSuccessResponseModel;

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
    void onEditUserProfileFailure(EditUserProfileFailResponseModel response);
}
