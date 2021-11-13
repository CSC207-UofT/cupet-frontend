package com.example.cupetfrontend.drivers.api;

import com.example.cupetfrontend.drivers.api.routes.PetRoutesStore;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.*;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PetAPIGateway extends APIGateway implements IPetAPIGateway {
    IServerRequestManager requestManager;

    public PetAPIGateway(IServerRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override
    public void createPet(APICreatePetRequestModel requestData, IServerResponseListener responseListener) {
        Map<String, String> requestDataMap = new HashMap<>();

        requestDataMap.put("name", requestData.getName());
        requestDataMap.put("age", requestData.getAge());
        requestDataMap.put("breed", requestData.getBreed());
        requestDataMap.put("biography", requestData.getBiography());

        JSONObject requestBody = new JSONObject(requestDataMap);

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.CREATE_PET);

        requestManager.makePostRequest(url, requestBody, createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void fetchPetProfile(APIFetchPetProfileRequestModel requestData, IServerResponseListener responseListener) {
        Map<String, String> requestDataMap = new HashMap<>();

        requestDataMap.put("petId", requestData.getPetId());
        JSONObject requestBody = new JSONObject(requestDataMap);

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.FETCH_PET_PROFILE);

        requestManager.makePostRequest(url, requestBody, createAuthHeaders(requestData.getToken()), responseListener);
    }

    // TODO: Fill with dummy data until back-end is done

    @Override
    public void editPet(APIEditPetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(null);
    }

    @Override
    public void getPotentialMatches(APIGetPotentialMatchesRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(null);
    }

    @Override
    public void intendToMatch(APIIntendToMatchRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(null);
    }

    @Override
    public void getMatches(APIGetMatchesRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(null);
    }
}
