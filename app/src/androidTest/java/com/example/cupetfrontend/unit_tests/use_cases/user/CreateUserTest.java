package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.user.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.UserCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorSuccessResponseModel;
import com.example.cupetfrontend.use_cases.user.UserCreator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreateUserTest extends UseCaseTestClass {
    @Test
    public void testCreateUserSuccess() {
        UserCreatorRequestModel request = new UserCreatorRequestModel(
                "dummy first name", "dummy last name", "dummy email",
                "dummy password", "dummy address", "dummy city");

        new UserCreator(successUserAPIGateway, new UserCreatorOutputBoundary() {
            @Override
            public void onCreateUserSuccess(UserCreatorSuccessResponseModel response) {
                assertEquals(response.getFirstName(), "dummy first name");
                assertEquals(response.getLastName(), "dummy last name");
                assertEquals(response.getEmail(), "dummy email");
                assertEquals(response.getHomeAddress(), "dummy address");
                assertEquals(response.getCity(), "dummy city");

                setTaskComplete();
            }

            @Override
            public void onCreateUserFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).createUser(request);

        awaitForTask(1000);
    }

    @Test
    public void testCreateUserFailure() {
        UserCreatorRequestModel request = new UserCreatorRequestModel(
                "dummy first name", "dummy last name", "dummy email",
                "dummy password", "dummy home address", "dummy city");

        new UserCreator(failureUserAPIGateway, new UserCreatorOutputBoundary() {
            @Override
            public void onCreateUserSuccess(UserCreatorSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onCreateUserFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).createUser(request);

        awaitForTask(1000);
    }
}
