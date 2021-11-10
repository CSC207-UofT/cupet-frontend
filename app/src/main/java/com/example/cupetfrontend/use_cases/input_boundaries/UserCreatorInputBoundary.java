package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.UserCreatorRequestModel;

public interface UserCreatorInputBoundary {
    void createUser(UserCreatorRequestModel request);
}
