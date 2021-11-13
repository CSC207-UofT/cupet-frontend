package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.IntendToMatchRequestModel;

public interface IntendToMatchInputBoundary {
    /**
     * Intend to match your pet with another pet given request data
     * @param request The request data
     */
    void intendToMatch(IntendToMatchRequestModel request);
}
