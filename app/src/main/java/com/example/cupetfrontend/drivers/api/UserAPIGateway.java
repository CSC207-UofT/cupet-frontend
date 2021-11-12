package com.example.cupetfrontend.drivers.api;

import com.example.cupetfrontend.drivers.api.routes.UserRoutesStore;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.*;
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
        requestDataMap.put("homeAddress", requestData.getHomeAddress());
        requestDataMap.put("password", requestData.getPassword());
        requestDataMap.put("email", requestData.getEmail());
        requestDataMap.put("city", requestData.getCity());

        JSONObject requestBody = new JSONObject(requestDataMap);
        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.CREATE_USER);

        requestManager.makePostRequest(url, requestBody, responseListener);
    }

    @Override
    public void fetchUserProfile(APIFetchUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        // TODO: Fill with real API calls once backend endpoints are done
        responseListener.onRequestSuccess(null);
    }

    @Override
    public void editUserProfile(APIEditUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        // TODO: Fill with real API calls once backend endpoints are done
        responseListener.onRequestSuccess(null);
    }

    @Override
    public void fetchUserAccount(APIFetchUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        // TODO: Fill with real API calls once backend endpoints are done
        responseListener.onRequestSuccess(null);
    }

    @Override
    public void editUserAccount(APIEditUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        // TODO: Fill with real API calls once backend endpoints are done
        responseListener.onRequestSuccess(null);
    }

    @Override
    public void getPets(APIGetPetsRequestModel requestData, IServerResponseListener responseListener) {
        // TODO: Fill with real API calls once backend endpoints are done
        responseListener.onRequestSuccess(null);
    }
}
