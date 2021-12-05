package com.example.cupetfrontend.ui.my_pet_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPetProfileViewModel;

/**
 * A ViewModel class for the viewing Pet Profile page.
 */
public class PetProfileViewModel extends ViewModel implements IPetProfileViewModel {
    private final IPetController petController;
    private final MutableLiveData<PetProfileResult> petProfileResult = new MutableLiveData<>();

    public PetProfileViewModel(IPetController petController) {
        this.petController = petController;
    }

    LiveData<PetProfileResult> getPetProfileResult() {
        return petProfileResult;
    }

    /**
     * Fetch a pet's profile request
     * @param token The session token of the user
     * @param petId The id of the pet
     */
    public void fetchPetProfile(String token, String petId) {
        petController.getPetProfile(token, petId);
    }

    @Override
    public void onPetProfileSuccess(String petImage, String petName, String petAge, String petBreed, String petBio) {
        PetProfileResult newFetchPetResult = new PetProfileResult(
                petImage,
                petName,
                petAge,
                petBreed,
                petBio);
        petProfileResult.setValue(newFetchPetResult);
    }

    @Override
    public void onPetProfileFailure(String message) {
        PetProfileResult newFetchPetResult = new PetProfileResult(true, message);
        petProfileResult.setValue(newFetchPetResult);
    }
}
