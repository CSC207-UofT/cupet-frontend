package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.*;

import java.util.HashMap;

/**
 * A mock of the PetAPIGateway which always returns a successful response.
 */
public class MockSuccessPetAPIGateway extends MockSuccessAPIGateway implements IPetAPIGateway{
    @Override
    public void createPet(APICreatePetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("petId", "dummy pet id");
            put("name", requestData.getName());
            put("age", requestData.getAge());
            put("breed", requestData.getBreed());
            put("biography", requestData.getBiography());
        }}));
    }

    @Override
    public void fetchPetProfile(APIFetchPetProfileRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("name", "dummy name");
            put("age", "dummy age");
            put("breed", "dummy breed");
            put("biography", "dummy biography");
        }}));
    }

    @Override
    public void editPet(APIEditPetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("petId", requestData.getPetId());
            put("name", requestData.getName());
            put("age", requestData.getAge());
            put("breed", requestData.getBreed());
            put("biography", requestData.getBiography());
        }}));
    }

    @Override
    public void getPotentialMatches(APIGetPotentialMatchesRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createPetIdSuccessJSON(new String[]{"a", "b", "c"}));
    }

    @Override
    public void intendToMatch(APIIntendToMatchRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<>()));
    }

    @Override
    public void rejectMatch(APIRejectMatchRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<>()));
    }

    @Override
    public void getMatches(APIGetMatchesRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createPetIdSuccessJSON(new String[]{"a", "b", "c"}));
    }

    @Override
    public void unMatchPet(APIUnMatchPetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<>()));
    }
}
