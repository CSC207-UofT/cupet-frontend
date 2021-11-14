package com.example.cupetfrontend.dependency_selector;

import android.content.Context;
import com.example.cupetfrontend.drivers.api.HTTPRequestManager;
import com.example.cupetfrontend.drivers.api.UserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;

public class APIDependencies {
    private IServerRequestManager requestManager;
    private IUserAPIGateway userAPIGateway;

    public APIDependencies(Context applicationContext) {
        selectRequestManager(applicationContext);
        selectUserAPIGateway(requestManager);
    }

    private void selectRequestManager (Context applicationContext) {
        requestManager = new HTTPRequestManager(applicationContext);
    }

    private void selectUserAPIGateway (IServerRequestManager requestManager) {
        userAPIGateway = new UserAPIGateway(requestManager);
    }

    public IServerRequestManager getRequestManager() {
        return requestManager;
    }

    public IUserAPIGateway getUserAPIGateway() {
        return userAPIGateway;
    }
}
