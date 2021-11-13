package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.FetchPetProfileInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.PetCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.PetCreatorRequestModel;

/**
 * A controller which accesses all use cases relating
 * to pets.
 */
public class PetController implements IPetController {
    PetCreatorInputBoundary petCreator;
    FetchPetProfileInputBoundary fetchPetProfile;

    public PetController(PetCreatorInputBoundary petCreator, FetchPetProfileInputBoundary fetchPetProfile) {
        this.petCreator = petCreator;
        this.fetchPetProfile = fetchPetProfile;
    }

    @Override
    public void createPet(String token, String name, String age, String breed, String biography) {
        PetCreatorRequestModel request = new PetCreatorRequestModel(token, name, age, breed, biography);

        petCreator.createPet(request);
    }

    @Override
    public void getPetProfile(String token, String petId) {
        FetchPetProfileRequestModel request = new FetchPetProfileRequestModel(token, petId);

        fetchPetProfile.fetchPetProfile(request);
    }

    @Override
    public void editPet(String token, String newName, String newAge, String newBreed, String newBiography) {

    }

    @Override
    public void getPotentialMatches(String token, String petId) {

    }

    @Override
    public void intendToMatch(String token, String myPetId, String otherPetId) {

    }

    @Override
    public void getMatches(String token, String myPetId) {

    }
}
