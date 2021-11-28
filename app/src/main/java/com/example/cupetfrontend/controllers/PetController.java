package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.use_cases.GetPotentialMatches;
import com.example.cupetfrontend.use_cases.RejectMatch;
import com.example.cupetfrontend.use_cases.SetPetProfileImage;
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
    RejectMatchInputBoundary rejectMatch;
    GetMatchesInputBoundary getMatches;
    UnMatchPetInputBoundary unMatchPet;
    SetPetProfileImageInputBoundary setPetProfileImage;
    AddToPetImageGalleryInputBoundary addToPetImageGallery;
    RemoveFromPetImageGalleryInputBoundary removeFromPetImageGallery;

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

    public void setRejectMatch(RejectMatchInputBoundary rejectMatch) {
        this.rejectMatch = rejectMatch;
    }

    public void setGetMatches(GetMatchesInputBoundary getMatches) {
        this.getMatches = getMatches;
    }

    public void setUnMatchPet(UnMatchPetInputBoundary unMatchPet) {
        this.unMatchPet = unMatchPet;
    }

    public void setSetPetProfileImage(SetPetProfileImageInputBoundary setPetProfileImage) {
        this.setPetProfileImage = setPetProfileImage;
    }

    public void setAddToPetImageGallery(AddToPetImageGalleryInputBoundary addToPetImageGallery) {
        this.addToPetImageGallery = addToPetImageGallery;
    }

    public void setRemoveFromPetImageGallery(RemoveFromPetImageGalleryInputBoundary removeFromPetImageGallery) {
        this.removeFromPetImageGallery = removeFromPetImageGallery;
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
    public void editPet(String token, String petId, String newName, String newAge, String newBreed, String newBiography) {
        EditPetRequestModel request = new EditPetRequestModel(token, petId, newName, newAge, newBreed, newBiography);

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

    @Override
    public void unMatchPet(String token, String myPetId, String otherPetId) {
        UnMatchPetRequestModel request = new UnMatchPetRequestModel(token, myPetId, otherPetId);

        unMatchPet.unMatchPet(request);
    }

    @Override
    public void setPetProfileImage(String token, String petId, String imgB64) {
        SetPetProfileImageRequestModel request = new SetPetProfileImageRequestModel(
                token, petId, imgB64
        );

        setPetProfileImage.setPetProfile(request);
    }

    @Override
    public void addToPetImageGallery(String token, String petId, String imgB64) {
        AddToPetImageGalleryRequestModel request = new AddToPetImageGalleryRequestModel(
                token, petId, imgB64
        );

        addToPetImageGallery.addToPetImageGallery(request);
    }

    @Override
    public void removeFromPetImageGallery(String token, String petId, String assetId) {
        RemoveFromPetImageGalleryRequestModel request = new RemoveFromPetImageGalleryRequestModel(
                token, petId, assetId
        );

        removeFromPetImageGallery.removeFromPetImageGallery(request);
    }
}
