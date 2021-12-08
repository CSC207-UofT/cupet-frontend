package com.example.cupetfrontend.ui.matched_pet_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.data_models.UserProfileData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IFetchUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.MatchedPetProfileContext;
import com.example.cupetfrontend.ui.user_profile.FetchUserProfileResult;

import javax.inject.Inject;

public class MatchedPetProfileViewModel extends ViewModel implements IMatchedPetProfileViewModel {
    private final MutableLiveData<MatchedPetProfileResult> matchedPetProfileResultData = new MutableLiveData<>();
    private final MutableLiveData<FetchUserProfileResult> fetchUserProfileResultData = new MutableLiveData<>();
    //private final IPetController petController;
    private final IUserController userController;
    private MatchedPetProfileContext context;

    @Inject
    public MatchedPetProfileViewModel(IUserController userController){
        //this.petController = petController;
        this.userController = userController;
    }

    public void fetchUserProfile(String token, String userId) {
        userController.fetchUserProfile(token, userId);
    }

    public LiveData<FetchUserProfileResult> getFetchUserProfileResult() {
        return this.fetchUserProfileResultData;
    }

    @Override
    public LiveData<MatchedPetProfileResult> getMatchedPetProfileResult() {
        return this.matchedPetProfileResultData;
    }

    @Override
    public void onMatchedPetProfileSuccess(PetModel petModel) {
        MatchedPetProfileResult newMatchedPetProfileResult = new MatchedPetProfileResult(petModel);
        matchedPetProfileResultData.setValue(newMatchedPetProfileResult);
    }

    @Override
    public void onMatchedPetProfileFailure(String message) {
        MatchedPetProfileResult newMatchedPetProfileResult = new MatchedPetProfileResult(true, message);
        matchedPetProfileResultData.setValue(newMatchedPetProfileResult);
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
    public void onFetchUserProfileSuccess(UserProfileData userProfileData) {
        fetchUserProfileResultData.setValue(new FetchUserProfileResult(userProfileData));
    }

    @Override
    public void onFetchUserProfileFailure(String message) {
        fetchUserProfileResultData.setValue(new FetchUserProfileResult(true, message));

    }
}
