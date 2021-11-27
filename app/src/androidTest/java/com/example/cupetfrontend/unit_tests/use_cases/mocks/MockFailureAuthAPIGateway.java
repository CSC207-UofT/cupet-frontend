package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APILoginRequestModel;

public class MockFailureAuthAPIGateway extends MockFailureAPIGateway implements IAuthAPIGateway {
    @Override
    public void login(APILoginRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }
}
