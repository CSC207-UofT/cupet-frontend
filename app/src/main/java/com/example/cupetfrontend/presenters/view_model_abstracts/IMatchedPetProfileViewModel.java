package com.example.cupetfrontend.presenters.view_model_abstracts;

import androidx.lifecycle.LiveData;

import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.MatchedPetProfileContext;
import com.example.cupetfrontend.ui.matched_pet_profile.MatchedPetProfileOwnerContactInfoResult;
import com.example.cupetfrontend.ui.user_profile.FetchUserProfileResult;

public interface IMatchedPetProfileViewModel extends IFetchUserProfileViewModel {
    LiveData<MatchedPetProfileOwnerContactInfoResult> getUserContactInfoResult();

    void setContext(MatchedPetProfileContext context);

    MatchedPetProfileContext getContext();

    void fetchUserProfile(String token, String userId);
}
