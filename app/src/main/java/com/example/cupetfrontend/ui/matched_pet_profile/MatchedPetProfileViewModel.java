package com.example.cupetfrontend.ui.matched_pet_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IMatchedPetProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.MatchedPetProfileContext;

import javax.inject.Inject;

public class MatchedPetProfileViewModel extends ViewModel implements IMatchedPetProfileViewModel {
    private final MutableLiveData<MatchedPetProfileResult> matchedPetProfileResultData = new MutableLiveData<>();
    private final IPetController petController;
    private final IUserController userController;
    private MatchedPetProfileContext context;

    @Inject
    public MatchedPetProfileViewModel(IPetController petController, IUserController userController){
        this.petController = petController;
        this.userController = userController;
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
}
