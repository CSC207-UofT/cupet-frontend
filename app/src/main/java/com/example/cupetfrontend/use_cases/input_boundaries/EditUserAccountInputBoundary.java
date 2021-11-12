package com.example.cupetfrontend.use_cases.input_boundaries;

import com.example.cupetfrontend.use_cases.request_models.EditUserAccountRequestModel;

public interface EditUserAccountInputBoundary {
    /**
     * Edit a user's account given the request data
     * @param request The request data
     */
    void editUserAccount(EditUserAccountRequestModel request);
}
