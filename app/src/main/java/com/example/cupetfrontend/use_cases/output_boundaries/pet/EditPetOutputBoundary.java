package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.EditPetSuccessResponseModel;

/**
 * An interface defining a class responsible for receiving the response of an
 * edit pet request.
 */
public interface EditPetOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onEditPetSuccess(EditPetSuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onEditPetFailure(DefaultFailureResponseModel response);
}
