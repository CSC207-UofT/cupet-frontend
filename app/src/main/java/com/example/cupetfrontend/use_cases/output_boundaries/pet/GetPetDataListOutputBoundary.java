package com.example.cupetfrontend.use_cases.output_boundaries.pet;

import com.example.cupetfrontend.use_cases.data_models.PetData;

import java.util.List;

/**
 * An interface defining a class responsible for receiving the response of a
 * get pet data list request.
 */
public interface GetPetDataListOutputBoundary {
    /**
     * Method called when a successful get pet data list response is received-.
     *
     * @param response The list of pet data
     */
    void onGetPetDataListSuccess(List<PetData> response);

    /**
     * Method called when a failed get pet data list response is received.
     *
     * @param errorMessage An error message describing the issue
     */
    void onGetPetDataListFailure(String errorMessage);
}
