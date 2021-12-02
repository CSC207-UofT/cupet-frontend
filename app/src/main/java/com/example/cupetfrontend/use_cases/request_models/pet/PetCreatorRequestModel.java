package com.example.cupetfrontend.use_cases.request_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetProfile;

/**
 * A class containing the request data for creating a pet.
 */
public class PetCreatorRequestModel extends PetProfile {
    private final String token;

    public PetCreatorRequestModel(String token, String name,
                                  String age, String breed, String biography) {
        super(name, age, breed, biography);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
