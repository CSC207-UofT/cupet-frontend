package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.EditUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.user.EditUserAccount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EditUserAccountTest extends UseCaseTestClass {
    @Test
    public void testEditUserAccountSuccess(){
        EditUserAccountRequestModel request = new EditUserAccountRequestModel(
                "dummy token", "dummy first name", "dummy last name",
                "dummy email", "dummy password", "dummy address",
                "dummy city");

        new EditUserAccount(successUserAPIGateway, new EditUserAccountOutputBoundary() {
            @Override
            public void onEditUserAccountSuccess(EditUserAccountSuccessResponseModel response) {
                assertEquals(response.getFirstName(), "dummy first name");
                assertEquals(response.getLastName(), "dummy last name");
                assertEquals(response.getHomeAddress(), "dummy address");
                assertEquals(response.getCity(), "dummy city");
                assertEquals(response.getEmail(), "dummy email");

                setTaskComplete();
            }

            @Override
            public void onEditUserAccountFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).editUserAccount(request);

        awaitForTask(1000);
    }

    @Test
    public void testEditUserAccountFailure(){
        EditUserAccountRequestModel request = new EditUserAccountRequestModel(
                "dummy token", "dummy first name", "dummy last name",
                "dummy email", "dummy password", "dummy home address",
                "dummy city");

        new EditUserAccount(failureUserAPIGateway, new EditUserAccountOutputBoundary() {
            @Override
            public void onEditUserAccountSuccess(EditUserAccountSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onEditUserAccountFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).editUserAccount(request);

        awaitForTask(1000);
    }
}
