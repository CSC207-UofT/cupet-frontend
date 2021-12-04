package com.example.cupetfrontend.ui.pet_profile;

import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPetProfileViewModel;

/**
 * A ViewModel class for the viewing Pet Profile page.
 */
public class PetProfileViewModel extends ViewModel implements IPetProfileViewModel {
    private final IPetController petController;

    public PetProfileViewModel(IPetController petController) {
        this.petController = petController;
    }

    public void fetchPetProfile() {
        // TODO: add token and petId code here
        petController.getPetProfile("token", "petId");
    }

    @Override
    public void onFetchPetSuccess() {
        PetProfileResult newFetchPetResult = new PetProfileResult(false);

        // PetProfileResult.setValue(newFetchPetResult);
    }

    @Override
    public void onFetchPetFailure(String message) {
        PetProfileResult newFetchPetResult = new PetProfileResult(true, message);

        // PetProfileResult.setValue(newFetchPetResult);
    }
}
