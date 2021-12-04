package com.example.cupetfrontend.ui.create_pet;

/**
 * Class that stores the data entered into the create pet form.
 */
public class CreatePetFormData {
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
