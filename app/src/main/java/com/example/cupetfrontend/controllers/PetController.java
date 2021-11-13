package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.use_cases.GetPotentialMatches;
import com.example.cupetfrontend.use_cases.RejectMatch;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.*;
import com.example.cupetfrontend.use_cases.request_models.pet.*;

/**
 * A controller which accesses all use cases relating
 * to pets.
 */
public class PetController implements IPetController {
    PetCreatorInputBoundary petCreator;
    FetchPetProfileInputBoundary fetchPetProfile;
    EditPetInputBoundary editPet;
    GetPotentialMatchesInputBoundary getPotentialMatches;
    IntendToMatchInputBoundary intendToMatch;
    RejectMatch rejectMatch;
    GetMatchesInputBoundary getMatches;

    public void setPetCreator(PetCreatorInputBoundary petCreator) {
        this.petCreator = petCreator;
    }

    public void setFetchPetProfile(FetchPetProfileInputBoundary fetchPetProfile) {
        this.fetchPetProfile = fetchPetProfile;
    }

    public void setEditPet(EditPetInputBoundary editPet) {
        this.editPet = editPet;
    }

    public void setGetPotentialMatches(GetPotentialMatchesInputBoundary getPotentialMatches) {
        this.getPotentialMatches = getPotentialMatches;
    }

    public void setIntendToMatch(IntendToMatchInputBoundary intendToMatch) {
        this.intendToMatch = intendToMatch;
    }

    public void setRejectMatch(RejectMatch rejectMatch) {
        this.rejectMatch = rejectMatch;
    }

    public void setGetMatches(GetMatchesInputBoundary getMatches) {
        this.getMatches = getMatches;
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
        EditPetRequestModel request = new EditPetRequestModel(token, newName, newAge, newBreed, newBiography);

        editPet.editPet(request);
    }

    @Override
    public void getPotentialMatches(String token, String petId) {
        GetPotentialMatchesRequestModel request = new GetPotentialMatchesRequestModel(token, petId);

        getPotentialMatches.getPotentialMatches(request);
    }

    @Override
    public void intendToMatch(String token, String myPetId, String otherPetId) {
        IntendToMatchRequestModel request = new IntendToMatchRequestModel(token, myPetId, otherPetId);

        intendToMatch.intendToMatch(request);
    }

    @Override
    public void getMatches(String token, String myPetId) {
        GetMatchesRequestModel request = new GetMatchesRequestModel(token, myPetId);

        getMatches.getMatches(request);
    }

    @Override
    public void rejectMatch(String token, String myPetId, String otherPetId) {
        RejectMatchRequestModel request = new RejectMatchRequestModel(token, myPetId, otherPetId);

        rejectMatch.rejectMatch(request);
    }
}
