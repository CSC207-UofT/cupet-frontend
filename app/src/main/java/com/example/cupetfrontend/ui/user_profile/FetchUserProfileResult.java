package com.example.cupetfrontend.ui.user_profile;

import com.example.cupetfrontend.presenters.data_models.UserProfileData;


public class FetchUserProfileResult {
    private boolean isError;
    private String errorMessage;
    private UserProfileData userProfileData;

    public FetchUserProfileResult(boolean isError, String message) {
        this.isError = isError;
        this.errorMessage = message;
        this.userProfileData = null;
    }

    public FetchUserProfileResult(UserProfileData userProfileData) {
        this.isError = false;
        this.errorMessage = null;
        this.userProfileData = userProfileData;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public UserProfileData getUserProfileData() {
        return userProfileData;
    }
}
