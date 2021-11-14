package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * get matches request.
 */
public interface GetMatchesOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onGetMatchesSuccess(GetMatchesSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onGetMatchesFailure(GetMatchesFailResponseModel response);
}
