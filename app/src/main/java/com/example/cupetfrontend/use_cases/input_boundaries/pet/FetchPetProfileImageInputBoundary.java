package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileImageRequestModel;

public interface FetchPetProfileImageInputBoundary {
    /**
     * Fetch a pet's profile picture given request data
     * @param request The request data
     */
    void fetchPetProfileImage(FetchPetProfileImageRequestModel request);
}
