package com.example.cupetfrontend.use_cases.output_boundaries;

import com.example.cupetfrontend.use_cases.response_models.EditUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserAccountSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * edit user account request.
 */
public interface EditUserAccountOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onEditUserAccountSuccess(EditUserAccountSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onEditUserAccountFailure(EditUserAccountFailResponseModel response);
}