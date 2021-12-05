package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.SetPetProfileImageRequestModel;

public interface SetPetProfileImageInputBoundary {
    /**
     * Set a pet's profile image
     */
    void setPetProfileImage(SetPetProfileImageRequestModel request);
}
