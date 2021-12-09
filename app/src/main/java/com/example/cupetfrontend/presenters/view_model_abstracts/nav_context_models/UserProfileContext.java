package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

public class UserProfileContext {
    private final String userId;

    public UserProfileContext(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
