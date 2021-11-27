package com.example.cupetfrontend.drivers.api;

import com.example.cupetfrontend.drivers.api.routes.PetRoutesStore;
import com.example.cupetfrontend.drivers.api.routes.UserRoutesStore;
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

        requestDataMap.put("userId", UserIdFetcher.getUserId(requestData.getToken()));
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
        Map<String, String> queryParams = new HashMap<>();

        queryParams.put("petId", requestData.getPetId());

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.FETCH_PET_PROFILE);

        requestManager.makeGetRequest(url, queryParams, createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void editPet(APIEditPetRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>(){{
            put("newName", requestData.getNewName());
            put("newAge", requestData.getNewAge());
            put("newBreed", requestData.getNewBreed());
            put("newBiography", requestData.getNewBiography());
            put("petId", requestData.getPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.EDIT_PET_PROFILE);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void getPotentialMatches(APIGetPotentialMatchesRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>(){{
            put("petId", requestData.getPetId());
        }};

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.FETCH_PET_SWIPES);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void intendToMatch(APIIntendToMatchRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>(){{
            put("pet1Id", requestData.getMyPetId());
            put("pet2Id", requestData.getOtherPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.REJECT_PETS);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void rejectMatch(APIRejectMatchRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>(){{
            put("pet1Id", requestData.getMyPetId());
            put("pet2Id", requestData.getOtherPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.SWIPE_PETS);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void getMatches(APIGetMatchesRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>(){{
            put("petId", requestData.getMyPetId());
        }};

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.FETCH_MATCHES);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void unMatchPet(APIUnMatchPetRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>(){{
            put("pet1Id", requestData.getMyPetId());
            put("pet2Id", requestData.getOtherPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.UN_SWIPE_PETS);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }
}
