package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RemoveFromPetImageGallerySuccessResponseModel;


/**
 * An interface defining a class responsible for receiving the response of a
 * an add to pet image gallery request.
 */
public interface RemoveFromPetImageGalleryOutputBoundary {
    /**
     * Method called when a successful response is received.
     *
     * @param response The response data
     */
    void onRemoveFromPetImageGallerySuccess(RemoveFromPetImageGallerySuccessResponseModel response);

    /**
     * Method called when a failed response is received.
     *
     * @param response The response data
     */
    void onRemoveFromPetImageGalleryFailure(DefaultFailureResponseModel response);
}