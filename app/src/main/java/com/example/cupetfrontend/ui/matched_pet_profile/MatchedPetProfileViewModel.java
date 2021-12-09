package com.example.cupetfrontend.ui.matched_pet_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.MatchedPetProfileContext;
import com.example.cupetfrontend.ui.user_profile.FetchUserProfileResult;

import javax.inject.Inject;

public class MatchedPetProfileViewModel extends ViewModel implements IMatchedPetProfileViewModel {
    private final MutableLiveData<MatchedPetProfileOwnerContactInfoResult> fetchUserContactInfoResultData = new MutableLiveData<>();
    private final IUserController userController;
    private MatchedPetProfileContext context;

    @Inject
    public MatchedPetProfileViewModel(IUserController userController) {
        this.userController = userController;
    }

    public void fetchUserProfile(String token, String userId) {
        userController.fetchUserProfile(token, userId);
    }

    @Override
    public LiveData<MatchedPetProfileOwnerContactInfoResult> getUserContactInfoResult() {
        return this.fetchUserContactInfoResultData;
    }

    @Override
    public void setContext(MatchedPetProfileContext context) {
        this.context = context;
    }

    @Override
    public MatchedPetProfileContext getContext() {
        return this.context;
    }

    @Override
    public void onFetchOwnerContactInfoSuccess(UserProfileData userProfileData) {
        fetchUserContactInfoResultData.setValue(new
                MatchedPetProfileOwnerContactInfoResult(userProfileData));
    }

    @Override
    public void onFetchOwnerContactInfoFailure(String message) {
        fetchUserContactInfoResultData.setValue(new MatchedPetProfileOwnerContactInfoResult(true, message));

    }
}
