package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

import com.example.cupetfrontend.presenters.data_models.UserAccountData;

public class EditUserAccountContext {
    private final UserAccountData userAccountData;

    public EditUserAccountContext(UserAccountData userAccountData) {
        this.userAccountData = userAccountData;
    }

    public UserAccountData getUserAccountData() {
        return userAccountData;
    }
}
