package com.example.cupetfrontend.use_cases.input_boundaries.user;

import com.example.cupetfrontend.use_cases.request_models.user.UserCreatorRequestModel;

public interface UserCreatorInputBoundary {
    /**
     * Create a new user given the request data
     *
     * @param request The request data
     */
    void createUser(UserCreatorRequestModel request);
}
