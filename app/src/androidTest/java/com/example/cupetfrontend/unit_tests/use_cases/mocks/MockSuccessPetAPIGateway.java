package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIEditPetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIFetchPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIFetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIIntendToMatchRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIRejectMatchRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APISetPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIUnMatchPetRequestModel;

import java.util.HashMap;

/**
 * A mock of the PetAPIGateway which always returns a successful response.
 */
public class MockSuccessPetAPIGateway extends MockSuccessAPIGateway implements IPetAPIGateway {
    @Override
    public void createPet(APICreatePetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>() {{
            put("petId", "dummy pet id");
            put("name", requestData.getName());
            put("age", requestData.getAge());
            put("breed", requestData.getBreed());
            put("biography", requestData.getBiography());
        }}));
    }

    @Override
    public void fetchPetProfile(APIFetchPetProfileRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>() {{
            put("name", "dummy name");
            put("age", "dummy age");
            put("breed", "dummy breed");
            put("biography", "dummy biography");
            put("profileImgUrl", "dummy url");
        }}));
    }

    @Override
    public void editPet(APIEditPetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>() {{
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

    @Override
    public void setPetProfileImage(APISetPetProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>() {{
            put("url", "dummy url");
        }}));
    }

    @Override
    public void fetchPetProfileImage(APIFetchPetProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>() {{
            put("url", "dummy url");
        }}));
    }
}
