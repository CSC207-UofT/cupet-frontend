package com.example.cupetfrontend.presenters.view_model_abstracts;

import androidx.lifecycle.LiveData;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.MatchedPetProfileContext;
import com.example.cupetfrontend.ui.matched_pet_profile.MatchedPetProfileResult;

public interface IMatchedPetProfileViewModel {
    LiveData<MatchedPetProfileResult> getMatchedPetProfileResult();

    void onMatchedPetProfileSuccess(PetModel petModel);

    void onMatchedPetProfileFailure(String message);

    void setContext(MatchedPetProfileContext context);

    MatchedPetProfileContext getContext();
}
