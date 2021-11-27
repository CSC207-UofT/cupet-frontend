package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.UnMatchPet;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.UnMatchPetOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.UnMatchPetRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.UnMatchPetFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.UnMatchPetSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UnMatchPetTest extends UseCaseTestClass {
    @Test
    public void testUnMatchPetSuccess(){
        UnMatchPetRequestModel request = new UnMatchPetRequestModel(
                "dummy token", "dummy pet id", "dummy other pet id");

        new UnMatchPet(successPetAPIGateway, new UnMatchPetOutputBoundary() {
            @Override
            public void onUnMatchPetSuccess(UnMatchPetSuccessResponseModel response) {
                setTaskComplete();
            }

            @Override
            public void onUnMatchPetFailure(UnMatchPetFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).unMatchPet(request);

        awaitForTask(1000);
    }

    @Test
    public void testUnMatchPetFailure(){
        UnMatchPetRequestModel request = new UnMatchPetRequestModel(
                "dummy token", "dummy pet id", "dummy other pet id");

        new UnMatchPet(failurePetAPIGateway, new UnMatchPetOutputBoundary() {
            @Override
            public void onUnMatchPetSuccess(UnMatchPetSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onUnMatchPetFailure(UnMatchPetFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).unMatchPet(request);

        awaitForTask(1000);
    }
}
