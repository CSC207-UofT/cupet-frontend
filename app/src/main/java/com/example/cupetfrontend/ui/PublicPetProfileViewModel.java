package com.example.cupetfrontend.ui.public_pet_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPetProfileViewModel;
import com.example.cupetfrontend.ui.my_pet_profile.PetProfileResult;

public class PublicPetProfileViewModel extends ViewModel implements IPetProfileViewModel { //IUserProfileViewModel
    MutableLiveData<PetProfileResult> fetchPetProfileResult = new MutableLiveData<>();
    //MutableLiveData<UserProfileResult> fetchUserProfileResult = new MutableLiveData<>();

    private final IPetController petController;
    private final IUserController userController;

    public PublicPetProfileViewModel(IPetController petController, IUserController userController) {
        this.petController = petController;
        this.userController = userController;
    }

    public LiveData<PetProfileResult> fetchPetProfileResult() {
        return fetchPetProfileResult;
    }

//    public LiveData<UserProfileResult> fetchUserProfileResult() {
//        return fetchUserProfileResult;
//    }


    /**
     * Fetch a pet's profile request
     * @param token The session token of the user
     * @param petId The id of the pet
     */
    public void fetchPetProfile(String token, String petId) {
        petController.getPetProfile(token, petId);
    }


    /**
     * Fetch a user's profile request
     * @param token The session token of the user
     * @param userId The id of the user
     */
    public void fetchUserProfile(String token, String userId) {
        userController.fetchUserProfile(token, userId);
    }


    @Override
    public void onPetProfileSuccess(String petImage, String petName, String petAge, String petBreed, String petBio) {
        PetProfileResult newFetchPetResult = new PetProfileResult(
                petImage,
                petName,
                petAge,
                petBreed,
                petBio);
        fetchPetProfileResult.setValue(newFetchPetResult);

    }

    @Override
    public void onPetProfileFailure(String message) {
        PetProfileResult newFetchPetResult = new PetProfileResult(true, message);
        fetchPetProfileResult.setValue(newFetchPetResult);
    }


//    @Override
//    public void onUserProfileSuccess(String email, String phoneNumber,
//                                   String facebook, String instagram, String profileImgUrl ) {
//
//    }
//
//    @Override
//    public void onUserProfileFailure(String message) {
//
//    }
}
