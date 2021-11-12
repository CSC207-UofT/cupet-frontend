package com.example.cupetfrontend.use_cases.output_boundaries;

import com.example.cupetfrontend.use_cases.response_models.GetPetsFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.GetPetsSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * get pets request.
 */
public interface GetPetsOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onGetPetsSuccess(GetPetsSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onGetPetsFailure(GetPetsFailResponseModel response);
}
