package com.example.cupetfrontend.ui.user_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IFetchUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UserProfileContext;

import java.util.Objects;

public class UserProfileViewModel implements IUserProfileViewModel {
    private final IUserController userController;
    private final MutableLiveData<FetchUserProfileResult> fetchUserProfileResult = new MutableLiveData<>();
    private UserProfileContext context;

    public UserProfileViewModel(IUserController userController) {
        this.userController = userController;
    }

    @Override
    public void fetchUserProfile(String token, String userId) {
        userController.fetchUserProfile(token, userId);
    }

    @Override
    public LiveData<FetchUserProfileResult> getFetchUserProfileResult() {
        return this.fetchUserProfileResult;
    }

    @Override
    public void onFetchUserProfileSuccess(UserProfileData userProfileData) {
        fetchUserProfileResult.setValue(new FetchUserProfileResult(userProfileData));
    }

    @Override
    public void onFetchUserProfileFailure(String message) {
        fetchUserProfileResult.setValue(new FetchUserProfileResult(true, message));
    }

    @Override
    public void setContext(UserProfileContext context) {
        this.context = context;
    }

    @Override
    public UserProfileContext getContext() {
        return context;
    }
}
