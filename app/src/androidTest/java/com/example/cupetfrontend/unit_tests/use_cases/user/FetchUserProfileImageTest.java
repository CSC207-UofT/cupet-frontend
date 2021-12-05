package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.FetchPetProfileImage;
import com.example.cupetfrontend.use_cases.FetchUserProfileImage;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetProfileImageSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserProfileImageSuccessResponseModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FetchUserProfileImageTest extends UseCaseTestClass {
    @Test
    public void testFetchUserProfileImageSuccess(){
        FetchUserProfileImageRequestModel request = new FetchUserProfileImageRequestModel(
                "dummy token", "dummy user id");

        new FetchUserProfileImage(successUserAPIGateway, new FetchUserProfileImageOutputBoundary() {
            @Override
            public void onFetchUserProfileImageSuccess(UserProfileImageSuccessResponseModel response) {
                assertEquals(response.getImgUrl(), "dummy url");
                setTaskComplete();
            }

            @Override
            public void onFetchUserProfileImageFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }

        }).fetchUserProfileImage(request);

        awaitForTask(1000);
    }

    @Test
    public void testFetchPetProfileImageFailure(){
        FetchUserProfileImageRequestModel request = new FetchUserProfileImageRequestModel(
                "dummy token", "dummy user id");

        new FetchUserProfileImage(failureUserAPIGateway, new FetchUserProfileImageOutputBoundary() {
            @Override
            public void onFetchUserProfileImageSuccess(UserProfileImageSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onFetchUserProfileImageFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();            }

        }).fetchUserProfileImage(request);

        awaitForTask(1000);
    }
}
