package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.data_models.UserProfileData;

public interface IFetchUserProfileViewModel {
    void onFetchUserProfileSuccess(UserProfileData userProfileData);

    void onFetchUserProfileFailure(String message);
}
