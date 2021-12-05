package com.example.cupetfrontend.drivers.api;

import com.example.cupetfrontend.drivers.api.routes.PetRoutesStore;
import com.example.cupetfrontend.drivers.api.routes.UserRoutesStore;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.*;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A class responsible for making API requests relating to users.
 */
public class UserAPIGateway extends APIGateway implements IUserAPIGateway {
    IServerRequestManager requestManager;

    public UserAPIGateway(IServerRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override
    public void createUser(APICreateUserRequestModel requestData, IServerResponseListener responseListener) {
        Map<String, String> requestDataMap = new HashMap<>();

        requestDataMap.put("firstName", requestData.getFirstName());
        requestDataMap.put("lastName", requestData.getLastName());
        requestDataMap.put("currentAddress", requestData.getHomeAddress());
        requestDataMap.put("password", requestData.getPassword());
        requestDataMap.put("emailAddress", requestData.getEmail());
        requestDataMap.put("currentCity", requestData.getCity());

        JSONObject requestBody = new JSONObject(requestDataMap);
        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.CREATE_USER);

        requestManager.makePostRequest(url, requestBody, responseListener);
    }

    @Override
    public void fetchUserProfile(APIFetchUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>(){{
            put("userId", UserIdFetcher.getUserId(requestData.getToken()));
        }};

        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.FETCH_USER_PROFILE);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void editUserProfile(APIEditUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>(){{
            put("newBiography", requestData.getBiography());
            put("newInstagram", requestData.getInstagram());
            put("newFacebook", requestData.getFacebook());
            put("newPhoneNumber", requestData.getPhoneNumber());
            put("userId", UserIdFetcher.getUserId(requestData.getToken()));
        }});

        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.EDIT_USER_PROFILE);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void fetchUserAccount(APIFetchUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>(){{
            put("userId", UserIdFetcher.getUserId(requestData.getToken()));
        }};

        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.FETCH_USER_ACCOUNT);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void editUserAccount(APIEditUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>(){{
            put("newFirstName", requestData.getFirstName());
            put("newLastName", requestData.getLastName());
            put("newAddress", requestData.getHomeAddress());
            put("newCity", requestData.getCity());
            if (requestData.getPassword() != null){
                put("newPassword", requestData.getPassword());
            }
            put("newEmail", requestData.getEmail());
            put("userId", UserIdFetcher.getUserId(requestData.getToken()));
        }});

        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.EDIT_USER_ACCOUNT);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void getPets(APIGetPetsRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>(){{
            put("userId", UserIdFetcher.getUserId(requestData.getToken()));
        }};

        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.FETCH_PETS);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void setUserProfileImage(APISetUserProfileImageRequestModel requestData,
                                    IServerResponseListener responseListener) {
        JSONObject requestBody = new JSONObject(new HashMap<String, String>(){{
            put("base64Encoded", requestData.getImgB64());
        }});

        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.SET_PROFILE_IMAGE);

        requestManager.makePostRequest(url, requestBody,
                createAuthHeaders(requestData.getToken()), responseListener);
    }

    @Override
    public void fetchUserProfileImage(APIFetchUserProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        HashMap<String, String> queryParams = new HashMap<String, String>(){{
            put("userId", requestData.getUserId());
        }};

        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.FETCH_USER_PROFILE_IMAGE);

        requestManager.makeGetRequest(url, queryParams,
                createAuthHeaders(requestData.getToken()), responseListener);
    }
}
