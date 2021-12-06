package com.example.cupetfrontend.ui.public_pet_profile.display_pet_profile_fragment;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.cupetfrontend.ui.my_pet_profile.PetProfileResult;

public class DisplayPetProfileViewModel {
    private MutableLiveData<PetProfileResult> petProfileData;

    public LiveData<PetProfileResult> getPetProfileData(){
        return petProfileData;
    }

    public void setPetProfileInfoData(String petName, String petAge, String petBreed, String petBio, String petImageUrl) {
        petProfileData.setValue(new PetProfileResult(petImageUrl, petName, petAge, petBreed, petBio));
    }
}