package com.example.cupetfrontend.data.model;

public class PetModel {

    private String petId;
    private String petName;
    private String petBreed;
    private String petImageUrl;
    private String petAge;


    public PetModel(String petId, String petName, String petAge, String petBreed, String petImageUrl){
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
        this.petBreed = petBreed;
        this.petImageUrl = petImageUrl;
    }

    public PetModel(String petId, String petName, String petAge, String petBreed){
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
        this.petBreed = petBreed;
        this.petImageUrl = "https://static.thenounproject.com/png/963949-200.png";
    }

    public String getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String getPetImageUrl() {
        return petImageUrl;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetImageUrl(String petImageUrl) {
        this.petImageUrl = petImageUrl;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }
}