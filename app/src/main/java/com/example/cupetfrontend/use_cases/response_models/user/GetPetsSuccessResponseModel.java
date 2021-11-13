package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.response_models.PetData;

import java.util.List;

public class GetPetsSuccessResponseModel {
    private final List<PetData> pets;

    public GetPetsSuccessResponseModel(List<PetData> pets) {
        this.pets = pets;
    }

    public List<PetData> getPets() {
        return pets;
    }
}
