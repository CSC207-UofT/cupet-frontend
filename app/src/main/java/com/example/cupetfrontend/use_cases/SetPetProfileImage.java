package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.SetPetProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.SetPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.SetPetProfileImageRequestModel;

public class SetPetProfileImage implements SetPetProfileImageInputBoundary {
    IPetAPIGateway petAPIGateway;
    SetPetProfileImageOutputBoundary outputBoundary;

    public SetPetProfileImage(IPetAPIGateway petAPIGateway, SetPetProfileImageOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void setPetProfile(SetPetProfileImageRequestModel request) {

    }
}
