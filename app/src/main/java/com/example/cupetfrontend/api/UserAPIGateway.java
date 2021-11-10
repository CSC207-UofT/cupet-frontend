package com.example.cupetfrontend.api;

import com.example.cupetfrontend.api.routes.UserRoutesStore;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APICreateUserRequestModel;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class UserAPIGateway implements IUserAPIGateway {
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

        JSONObject requestBody = new JSONObject(requestDataMap);
        String url = UserRoutesStore.toAbsoluteRoute(UserRoutesStore.CREATE_USER);

        requestManager.makeGetRequest(url, requestBody, responseListener);
    }
}
