package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.user.FetchUserProfile;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FetchUserProfileTest extends UseCaseTestClass {
    @Test
    public void testFetchUserProfileSuccess(){
        FetchUserProfileRequestModel request = new FetchUserProfileRequestModel(
                "dummy token", "dummy user id");

        new FetchUserProfile(successUserAPIGateway, new FetchUserProfileOutputBoundary() {
            @Override
            public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {
                assertEquals(response.getBiography(), "dummy biography");
                assertEquals(response.getInstagram(), "dummy instagram");
                assertEquals(response.getFacebook(), "dummy facebook");
                assertEquals(response.getPhoneNumber(), "dummy phone number");
                assertEquals(response.getProfileImgUrl(), "dummy url");

                setTaskComplete();
            }

            @Override
            public void onFetchUserProfileFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).fetchUserProfile(request);

        awaitForTask(1000);
    }

    @Test
    public void testFetchUserProfileFailure(){
        FetchUserProfileRequestModel request = new FetchUserProfileRequestModel(
                "dummy token", "dummy user id");

        new FetchUserProfile(failureUserAPIGateway, new FetchUserProfileOutputBoundary() {
            @Override
            public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onFetchUserProfileFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).fetchUserProfile(request);

        awaitForTask(1000);
    }
}
