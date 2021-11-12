package com.example.cupetfrontend.use_cases.api_abstracts;

import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APIFetchPetProfileRequestModel;

/**
 * Interface with methods for interacting with an external API
 * (server) for actions relating to pets.
 */
public interface IPetAPIGateway {
    /**
     * Create a new pet.
     *
     * @param requestData The data needed to create a new pet.
     * @param responseListener A class with callback methods for when a response is received
     */
    void createPet(APICreatePetRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Fetch a pet's profile
     *
     * @param requestData The data needed to fetch the pet profile
     * @param responseListener A class with callback methods for when a response is received
     */
    void fetchPetProfile(APIFetchPetProfileRequestModel requestData, IServerResponseListener responseListener);
}
