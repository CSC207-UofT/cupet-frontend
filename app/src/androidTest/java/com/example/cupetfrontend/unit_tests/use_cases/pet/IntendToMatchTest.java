package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.IntendToMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.pet.IntendToMatch;
import com.example.cupetfrontend.use_cases.request_models.pet.IntendToMatchRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchSuccessResponseModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntendToMatchTest extends UseCaseTestClass {
    @Test
    public void testIntendToMatchSuccess() {
        IntendToMatchRequestModel request = new IntendToMatchRequestModel(
                "dummy token", "dummy pet id", "dummy other pet id");

        new IntendToMatch(successPetAPIGateway, new IntendToMatchOutputBoundary() {
            @Override
            public void onIntendToMatchSuccess(IntendToMatchSuccessResponseModel response) {
                setTaskComplete();
            }

            @Override
            public void onIntendToMatchFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).intendToMatch(request);

        awaitForTask(1000);
    }

    @Test
    public void testIntendToMatchFailure() {
        IntendToMatchRequestModel request = new IntendToMatchRequestModel(
                "dummy token", "dummy pet id", "dummy other pet id");

        new IntendToMatch(failurePetAPIGateway, new IntendToMatchOutputBoundary() {
            @Override
            public void onIntendToMatchSuccess(IntendToMatchSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onIntendToMatchFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).intendToMatch(request);

        awaitForTask(1000);
    }
}
