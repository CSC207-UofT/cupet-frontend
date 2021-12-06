package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

import com.example.cupetfrontend.presenters.data_models.UserProfileData;

public class EditUserProfileContext {
    private final UserProfileData preFilledData;

    public EditUserProfileContext(UserProfileData preFilledData) {
        this.preFilledData = preFilledData;
    }

    public UserProfileData getPreFilledData() {
        return preFilledData;
    }
}
