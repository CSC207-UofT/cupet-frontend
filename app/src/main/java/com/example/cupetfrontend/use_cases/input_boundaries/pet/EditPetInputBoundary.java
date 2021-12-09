package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.EditPetRequestModel;

public interface EditPetInputBoundary {
    /**
     * Edit a pet's profile given request data
     *
     * @param request The request data
     */
    void editPet(EditPetRequestModel request);
}
