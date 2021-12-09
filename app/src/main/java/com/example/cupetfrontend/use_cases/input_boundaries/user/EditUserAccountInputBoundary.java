package com.example.cupetfrontend.use_cases.input_boundaries.user;

import com.example.cupetfrontend.use_cases.request_models.user.EditUserAccountRequestModel;

public interface EditUserAccountInputBoundary {
    /**
     * Edit a user's account given the request data
     *
     * @param request The request data
     */
    void editUserAccount(EditUserAccountRequestModel request);
}
