package com.example.cupetfrontend.ui.get_matches.recycler;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUnMatchViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class GetMatchesRecyclerViewModel implements IUnMatchViewModel {
    private final MutableLiveData<UnMatchResult> unMatchResult = new MutableLiveData<>();
    private final IPetController petController;

    public GetMatchesRecyclerViewModel(IPetController petController) {
        this.petController = petController;
    }

    public LiveData<UnMatchResult> getUnMatchResult() {
        return unMatchResult;
    }

    public void unMatch(String token, String myPetId, String otherPetId) {
        petController.unMatchPet(token, myPetId, otherPetId);
    }

    @Override
    public void onCreateUserSuccess() {
        unMatchResult.setValue(new UnMatchResult(false));
    }

    @Override
    public void onCreateUserFailure(String message) {
        unMatchResult.setValue(new UnMatchResult(true, message));
    }
}
