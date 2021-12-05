package com.example.cupetfrontend.dependency_selector;

import android.content.Context;
import com.example.cupetfrontend.drivers.api.AuthAPIGateway;
import com.example.cupetfrontend.drivers.api.HTTPRequestManager;
import com.example.cupetfrontend.drivers.api.PetAPIGateway;
import com.example.cupetfrontend.drivers.api.UserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;

public class APIDependencies {
    private IServerRequestManager requestManager;
    private IUserAPIGateway userAPIGateway;
    private IPetAPIGateway petAPIGateway;
    private IAuthAPIGateway authAPIGateway;

    public APIDependencies(Context applicationContext) {
        selectRequestManager(applicationContext);
        selectUserAPIGateway(requestManager);
        selectPetAPIGateway(requestManager);
        selectAuthAPIGateway(requestManager);
    }

    private void selectRequestManager (Context applicationContext) {
        requestManager = new HTTPRequestManager(applicationContext);
    }

    private void selectUserAPIGateway (IServerRequestManager requestManager) {
        userAPIGateway = new UserAPIGateway(requestManager);
    }

    private void selectPetAPIGateway (IServerRequestManager requestManager) {
        petAPIGateway = new PetAPIGateway(requestManager);
    }

    private void selectAuthAPIGateway (IServerRequestManager requestManager) {
        authAPIGateway = new AuthAPIGateway(requestManager);
    }

    public IServerRequestManager getRequestManager() {
        return requestManager;
    }

    public IUserAPIGateway getUserAPIGateway() {
        return userAPIGateway;
    }

    public IPetAPIGateway getPetAPIGateway() {
        return petAPIGateway;
    }

    public IAuthAPIGateway getAuthAPIGateway() {
        return authAPIGateway;
    }
}
