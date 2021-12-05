package com.example.cupetfrontend.ui.my_pet_profile;

/**
 * Class that stores the data of the pet profile.
 */
public class PetProfileData {
    private String petName;
    private String petAge;
    private String petBreed;
    private String petBio;

    public String getPetName() {
        return petName;
    }

    public String getPetAge() {
        return petAge;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String getPetBio() {
        return petBio;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetBio(String petBio) {
        this.petBio = petBio;
    }
}
