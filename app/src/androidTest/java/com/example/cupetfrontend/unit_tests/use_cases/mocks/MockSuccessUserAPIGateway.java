package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.*;

import java.util.HashMap;

/**
 * A mock of the UserAPIGateway which always returns a successful response.
 */
public class MockSuccessUserAPIGateway extends MockSuccessAPIGateway implements IUserAPIGateway {

    @Override
    public void createUser(APICreateUserRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("userId", "dummy user id");
            put("firstName", requestData.getFirstName());
            put("lastName", requestData.getLastName());
            put("currentAddress", requestData.getHomeAddress());
            put("currentCity", requestData.getCity());
            put("email", requestData.getEmail());
        }}));
    }

    @Override
    public void fetchUserProfile(APIFetchUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("firstName", "dummy first name");
            put("lastName", "dummy last name");
            put("biography", "dummy biography");
            put("phoneNumber", "dummy phone number");
            put("email", "dummy email");
            put("instagram", "dummy instagram");
            put("facebook", "dummy facebook");
        }}));
    }

    @Override
    public void editUserProfile(APIEditUserProfileRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("newBiography", requestData.getBiography());
            put("newPhoneNumber", requestData.getPhoneNumber());
            put("newInstagram", requestData.getInstagram());
            put("newFacebook", requestData.getFacebook());
        }}));
    }

    @Override
    public void fetchUserAccount(APIFetchUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("firstName", "dummy first name");
            put("lastName", "dummy last name");
            put("currentAddress", "dummy address");
            put("currentCity", "dummy city");
            put("email", "dummy email");
        }}));
    }

    @Override
    public void editUserAccount(APIEditUserAccountRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("newFirstName", requestData.getFirstName());
            put("newLastName", requestData.getLastName());
            put("newCurrentAddress", requestData.getHomeAddress());
            put("newCurrentCity", requestData.getCity());
            put("newEmail", requestData.getEmail());
        }}));
    }

    @Override
    public void getPets(APIGetPetsRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createPetIdSuccessJSON(new String[]{"a", "b", "c"}));
    }

    @Override
    public void setUserProfileImage(APISetUserProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("url", "dummy url");
        }}));
    }

    @Override
    public void fetchUserProfileImage(APIFetchUserProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestSuccess(createDummySuccessJSON(new HashMap<String, String>(){{
            put("url", "dummy url");
        }}));
    }
}
