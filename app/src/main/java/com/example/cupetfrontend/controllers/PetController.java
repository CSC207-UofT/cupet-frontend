package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.use_cases.input_boundaries.PetCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.request_models.PetCreatorRequestModel;

/**
 * A controller which accesses all use cases relating
 * to pets.
 */
public class PetController implements IPetController {
    PetCreatorInputBoundary petCreator;

    public PetController(PetCreatorInputBoundary petCreator) {
        this.petCreator = petCreator;
    }

    @Override
    public void createPet(String token, String name, String age, String breed, String biography) {
        PetCreatorRequestModel request = new PetCreatorRequestModel(token, name, age, breed, biography)

        petCreator.createPet(request);
    }

    @Override
    public void getPetProfile(String token, String petId) {

    }
}
