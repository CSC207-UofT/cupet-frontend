package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.FetchUserAccountRequestModel;

public interface FetchUserAccountInputBoundary {
    /**
     * Fetch a user's account given request data
     * @param request The request data
     */
    void fetchUserAccount(FetchUserAccountRequestModel request);
}
