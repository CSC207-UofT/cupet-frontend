package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.LoginRequestModel;

public interface LoginInputBoundary {
    /**
     * Log a user in given the request data
     *
     * @param request The request data
     */
    void login(LoginRequestModel request);
}
