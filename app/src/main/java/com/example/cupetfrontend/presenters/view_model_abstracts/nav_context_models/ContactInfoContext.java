package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

public class ContactInfoContext {
    private final boolean isFromPetProfile;

    public ContactInfoContext(boolean isFromPetProfile) {
        this.isFromPetProfile = isFromPetProfile;
    }

    public boolean isFromPetProfile() {
        return isFromPetProfile;
    }
}
