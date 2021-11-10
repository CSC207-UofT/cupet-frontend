package com.example.cupetfrontend.use_cases.output_boundaries;

import com.example.cupetfrontend.use_cases.response_models.UserCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.UserCreatorSuccessResponseModel;

public interface UserCreatorOutputBoundary {
    void onCreateUserSuccess(UserCreatorSuccessResponseModel response);
    void onCreateUserFailure(UserCreatorFailResponseModel response);
}
