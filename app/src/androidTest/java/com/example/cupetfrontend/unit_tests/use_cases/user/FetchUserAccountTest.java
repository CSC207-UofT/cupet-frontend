package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.user.FetchUserAccount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FetchUserAccountTest extends UseCaseTestClass {
    @Test
    public void testFetchUserAccountSuccess(){
        FetchUserAccountRequestModel request = new FetchUserAccountRequestModel(
                "dummy token");

        new FetchUserAccount(successUserAPIGateway, new FetchUserAccountOutputBoundary() {
            @Override
            public void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response) {
                assertEquals(response.getFirstName(), "dummy first name");
                assertEquals(response.getLastName(), "dummy last name");
                assertEquals(response.getHomeAddress(), "dummy address");
                assertEquals(response.getCity(), "dummy city");
                assertEquals(response.getEmail(), "dummy email");

                setTaskComplete();
            }

            @Override
            public void onFetchUserAccountFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).fetchUserAccount(request);

        awaitForTask(1000);
    }

    @Test
    public void testFetchUserAccountFailure(){
        FetchUserAccountRequestModel request = new FetchUserAccountRequestModel(
                "dummy token");

        new FetchUserAccount(failureUserAPIGateway, new FetchUserAccountOutputBoundary() {
            @Override
            public void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onFetchUserAccountFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();

            }
        }).fetchUserAccount(request);

        awaitForTask(1000);
    }
}
