package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.RejectMatchRequestModel;

public interface RejectMatchInputBoundary {
    /**
     * Reject a potential match given request data
     *
     * @param request The request data
     */
    void rejectMatch(RejectMatchRequestModel request);
}
