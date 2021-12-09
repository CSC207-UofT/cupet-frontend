package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.UserProfileContext;
import com.example.cupetfrontend.ui.user_profile.FetchUserProfileResult;

import androidx.lifecycle.LiveData;

public interface IUserProfileViewModel extends IFetchUserProfileViewModel{
    void fetchUserProfile(String token, String userId);

    LiveData<FetchUserProfileResult> getFetchUserProfileResult();

    void setContext(UserProfileContext context);

    UserProfileContext getContext();
}
