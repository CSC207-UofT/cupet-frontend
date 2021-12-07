package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

import com.example.cupetfrontend.presenters.data_models.PetProfileData;

public class EditPetContext {
    private final PetProfileData petProfileData;

    public EditPetContext(PetProfileData petProfileData) {
        this.petProfileData = petProfileData;
    }

    public PetProfileData getPetProfileData() {
        return petProfileData;
    }
}
