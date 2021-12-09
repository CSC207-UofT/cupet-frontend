package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APICreateUserRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIEditUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIEditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIFetchUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIFetchUserProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIFetchUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIGetPetsRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APISetUserProfileImageRequestModel;

/**
 * A mock of the PetAPIGateway which always returns a failure response.
 */
public class MockFailureUserAPIGateway extends MockFailureAPIGateway implements IUserAPIGateway {
    @Override
    public void createUser(APICreateUserRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void fetchUserProfile(APIFetchUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void editUserProfile(APIEditUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void fetchUserAccount(APIFetchUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void editUserAccount(APIEditUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void getPets(APIGetPetsRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void setUserProfileImage(APISetUserProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void fetchUserProfileImage(APIFetchUserProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }
}
