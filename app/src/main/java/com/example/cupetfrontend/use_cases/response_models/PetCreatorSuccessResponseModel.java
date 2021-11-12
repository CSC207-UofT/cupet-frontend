package com.example.cupetfrontend.use_cases.response_models;

public class PetCreatorSuccessResponseModel {
    private final String name;
    private final String age;

    public PetCreatorSuccessResponseModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
