package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.EditPetRequestModel;

public class APIEditPetRequestModel extends EditPetRequestModel {
    public APIEditPetRequestModel(String token, String petId, String newName, String newAge, String newBreed, String newBiography) {
        super(token, petId, newName, newAge, newBreed, newBiography);
    }
}
