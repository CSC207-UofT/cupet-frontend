package com.example.cupetfrontend.use_cases.output_boundaries;

import com.example.cupetfrontend.use_cases.response_models.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.PetCreatorSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of a
 * create pet request.
 */
public interface PetCreatorOutputBoundary {
    /**
     * Method called when a successful response is received.
     * @param response The response data
     */
    void onCreatePetSuccess(PetCreatorSuccessResponseModel response);
    /**
     * Method called when a failed response is received.
     * @param response The response data
     */
    void onCreatePetFailure(PetCreatorFailResponseModel response);
}
