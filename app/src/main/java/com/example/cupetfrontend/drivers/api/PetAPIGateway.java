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
        JSONObject requestBody = new JSONObject(new HashMap<String, String>() {{
            put("newName", requestData.getName());
            put("newAge", requestData.getAge());
            put("newBreed", requestData.getBreed());
            put("newBiography", requestData.getBiography());
            put("petId", requestData.getPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.EDIT_PET_PROFILE);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void getPotentialMatches(APIGetPotentialMatchesRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>() {{
            put("petId", requestData.getPetId());
        }};

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.FETCH_PET_SWIPES);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void intendToMatch(APIIntendToMatchRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>() {{
            put("pet1Id", requestData.getMyPetId());
            put("pet2Id", requestData.getOtherPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.SWIPE_PETS);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void rejectMatch(APIRejectMatchRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>() {{
            put("pet1Id", requestData.getMyPetId());
            put("pet2Id", requestData.getOtherPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.REJECT_PETS);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void getMatches(APIGetMatchesRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>() {{
            put("petId", requestData.getPetId());
        }};

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.FETCH_MATCHES);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void unMatchPet(APIUnMatchPetRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>() {{
            put("pet1Id", requestData.getMyPetId());
            put("pet2Id", requestData.getOtherPetId());
        }});

        String url = PetRoutesStore.toAbsoluteRoute(PetRoutesStore.UN_MATCH_PETS);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void setPetProfileImage(APISetPetProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>() {{
            put("petId", requestData.getPetId());
            put("base64Encoded", requestData.getImgB64());
        }});

        String url = UserRoutesStore.toAbsoluteRoute(PetRoutesStore.SET_PET_PROFILE_IMAGE);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void addToPetImageGallery(APIAddToPetImageGalleryRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>() {{
            put("petId", requestData.getPetId());
            put("base64Encoded", requestData.getImgB64());
        }});

        String url = UserRoutesStore.toAbsoluteRoute(PetRoutesStore.ADD_TO_PET_IMAGE_GALLERY);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void removeFromPetImageGallery(APIRemoveFromPetImageGalleryRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>() {{
            put("petId", requestData.getPetId());
            put("assetId", requestData.getAssetId());
        }});

        String url = UserRoutesStore.toAbsoluteRoute(PetRoutesStore.REMOVE_FROM_PET_IMAGE_GALLERY);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void fetchPetProfileImage(APIFetchPetProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>() {{
            put("petId", requestData.getPetId());
        }};

        String url = UserRoutesStore.toAbsoluteRoute(PetRoutesStore.FETCH_PET_PROFILE_IMAGE);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }
}
