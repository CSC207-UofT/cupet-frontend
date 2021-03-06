package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.EditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileSuccessResponseModel;
import com.example.cupetfrontend.use_cases.user.EditUserProfile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EditUserProfileTest extends UseCaseTestClass {
    @Test
    public void testEditUserProfileSuccess() {
        EditUserProfileRequestModel request = new EditUserProfileRequestModel(
                "dummy token", "dummy biography", "dummy instagram",
                "dummy facebook", "dummy phone number");

        new EditUserProfile(successUserAPIGateway, new EditUserProfileOutputBoundary() {
            @Override
            public void onEditUserProfileSuccess(EditUserProfileSuccessResponseModel response) {
                assertEquals(response.getBiography(), "dummy biography");
                assertEquals(response.getInstagram(), "dummy instagram");
                assertEquals(response.getFacebook(), "dummy facebook");
                assertEquals(response.getPhoneNumber(), "dummy phone number");
                // TODO: add assertEquals for profileImgUrl once implemented in back-end

                setTaskComplete();
            }

            @Override
            public void onEditUserProfileFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).editUserProfile(request);

        awaitForTask(1000);
    }

    @Test
    public void testEditUserProfileFailure() {
        EditUserProfileRequestModel request = new EditUserProfileRequestModel(
                "dummy token", "dummy biography", "dummy instagram",
                "dummy facebook", "dummy phone number");

        new EditUserProfile(failureUserAPIGateway, new EditUserProfileOutputBoundary() {
            @Override
            public void onEditUserProfileSuccess(EditUserProfileSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onEditUserProfileFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();

            }
        }).editUserProfile(request);

        awaitForTask(1000);
    }
}
