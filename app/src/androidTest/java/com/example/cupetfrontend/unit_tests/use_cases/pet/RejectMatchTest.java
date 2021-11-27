package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.IntendToMatch;
import com.example.cupetfrontend.use_cases.RejectMatch;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.IntendToMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.RejectMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.IntendToMatchRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.RejectMatchRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RejectMatchFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RejectMatchSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RejectMatchTest extends UseCaseTestClass {
    @Test
    public void testRejectMatchSuccess(){
        RejectMatchRequestModel request = new RejectMatchRequestModel(
                "dummy token", "dummy pet id", "dummy other pet id");

        new RejectMatch(successPetAPIGateway, new RejectMatchOutputBoundary() {
            @Override
            public void onRejectMatchSuccess(RejectMatchSuccessResponseModel response) {
                setTaskComplete();
            }

            @Override
            public void onRejectMatchFailure(RejectMatchFailResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).rejectMatch(request);

        awaitForTask(1000);
    }

    @Test
    public void testRejectMatchFailure(){
        RejectMatchRequestModel request = new RejectMatchRequestModel(
                "dummy token", "dummy pet id", "dummy other pet id");

        new RejectMatch(failurePetAPIGateway, new RejectMatchOutputBoundary() {
            @Override
            public void onRejectMatchSuccess(RejectMatchSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onRejectMatchFailure(RejectMatchFailResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();            }
        }).rejectMatch(request);

        awaitForTask(1000);
    }
}
