package com.example.cupetfrontend.use_cases.response_models;

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
