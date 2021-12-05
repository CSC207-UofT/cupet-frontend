package com.example.cupetfrontend.unit_tests.use_cases;

import com.example.cupetfrontend.AsyncTestClass;
import com.example.cupetfrontend.unit_tests.use_cases.mocks.*;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import org.junit.Before;

public class UseCaseTestClass extends AsyncTestClass {
    public IAuthAPIGateway successAuthAPIGateway;
    public IAuthAPIGateway failureAuthAPIGateway;
    public IUserAPIGateway successUserAPIGateway;
    public IUserAPIGateway failureUserAPIGateway;
    public IPetAPIGateway successPetAPIGateway;
    public IPetAPIGateway failurePetAPIGateway;

    @Before
    public void apiGatewaySetUp() {
        successAuthAPIGateway = new MockSuccessAuthAPIGateway();
        failureAuthAPIGateway = new MockFailureAuthAPIGateway();
        successUserAPIGateway = new MockSuccessUserAPIGateway();
        failureUserAPIGateway = new MockFailureUserAPIGateway();
        successPetAPIGateway = new MockSuccessPetAPIGateway();
        failurePetAPIGateway = new MockFailurePetAPIGateway();
    }
}
