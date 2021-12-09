package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.pet.PetCreator;
import com.example.cupetfrontend.use_cases.request_models.pet.PetCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreatePetTest extends UseCaseTestClass {
    @Test
    public void testCreatePetSuccess(){
        PetCreatorRequestModel request = new PetCreatorRequestModel(
                "dummy token", "dummy pet name", "dummy age",
                "dummy breed", "dummy biography");

        new PetCreator(successPetAPIGateway, new PetCreatorOutputBoundary() {
            @Override
            public void onCreatePetSuccess(PetCreatorSuccessResponseModel response) {
                assertEquals(response.getName(), "dummy pet name");
                assertEquals(response.getAge(), "dummy age");
                assertEquals(response.getBreed(), "dummy breed");
                assertEquals(response.getBiography(), "dummy biography");

                setTaskComplete();
            }

            @Override
            public void onCreatePetFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).createPet(request);

        awaitForTask(1000);
    }

    @Test
    public void testCreatePetFailure(){
        PetCreatorRequestModel request = new PetCreatorRequestModel(
                "dummy token", "dummy pet name", "dummy age",
                "dummy breed", "dummy biography");

        new PetCreator(failurePetAPIGateway, new PetCreatorOutputBoundary() {
            @Override
            public void onCreatePetSuccess(PetCreatorSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onCreatePetFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).createPet(request);

        awaitForTask(1000);
    }
}
