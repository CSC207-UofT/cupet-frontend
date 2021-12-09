package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.user.SetUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.SetUserProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.SetUserProfileImageSuccessResponseModel;
import com.example.cupetfrontend.use_cases.user.SetUserProfileImage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SetUserProfileImageTest extends UseCaseTestClass {
    @Test
    public void testSetUserProfileImageSuccess(){
        SetUserProfileImageRequestModel request = new SetUserProfileImageRequestModel(
                "dummy token","dummy image b64");

        new SetUserProfileImage(successUserAPIGateway, new SetUserProfileImageOutputBoundary() {
            @Override
            public void onSetUserProfileImageSuccess(SetUserProfileImageSuccessResponseModel response) {
                assertEquals(response.getImgUrl(), "dummy url");
                setTaskComplete();
            }

            @Override
            public void onSetUserProfileImageFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).setUserProfileImage(request);

        awaitForTask(1000);
    }

    @Test
    public void testSetUserProfileImageFailure(){
        SetUserProfileImageRequestModel request = new SetUserProfileImageRequestModel(
                "dummy token","dummy image b64");

        new SetUserProfileImage(failureUserAPIGateway, new SetUserProfileImageOutputBoundary() {
            @Override
            public void onSetUserProfileImageSuccess(SetUserProfileImageSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onSetUserProfileImageFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();

            }
        }).setUserProfileImage(request);

        awaitForTask(1000);
    }
}
