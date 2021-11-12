package com.example.cupetfrontend.drivers.api;

import com.example.cupetfrontend.drivers.api.routes.AuthRoutesStore;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APILoginRequestModel;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A class responsible for making API requests relating to authentication.
 */
public class AuthAPIGateway extends APIGateway implements IAuthAPIGateway {
    IServerRequestManager requestManager;

    public AuthAPIGateway(IServerRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override
    public void login(APILoginRequestModel requestData, IServerResponseListener responseListener) {
        Map<String, String> requestDataMap = new HashMap<>();

        requestDataMap.put("email", requestData.getEmail());
        requestDataMap.put("password", requestData.getPassword());

        JSONObject requestBody = new JSONObject(requestDataMap);
        String url = AuthRoutesStore.toAbsoluteRoute(AuthRoutesStore.LOG_IN);

        requestManager.makePostRequest(url, requestBody, responseListener);
    }
}
