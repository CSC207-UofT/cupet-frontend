package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.pet.EditPet;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.EditPetRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.EditPetSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EditPetTest extends UseCaseTestClass {
    @Test
    public void testEditPetSuccess(){
        EditPetRequestModel request = new EditPetRequestModel(
                "dummy token", "dummy pet id", "dummy name",
                "dummy age", "dummy breed", "dummy biography");

        new EditPet(successPetAPIGateway, new EditPetOutputBoundary() {
            @Override
            public void onEditPetSuccess(EditPetSuccessResponseModel response) {
                assertEquals(response.getName(), "dummy name");
                assertEquals(response.getAge(), "dummy age");
                assertEquals(response.getBreed(), "dummy breed");
                assertEquals(response.getBiography(), "dummy biography");

                setTaskComplete();
            }

            @Override
            public void onEditPetFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).editPet(request);

        awaitForTask(1000);
    }

    @Test
    public void testEditPetFailure(){
        EditPetRequestModel request = new EditPetRequestModel(
                "dummy token", "dummy pet id", "dummy name",
                "dummy age", "dummy breed", "dummy biography");

        new EditPet(failurePetAPIGateway, new EditPetOutputBoundary() {
            @Override
            public void onEditPetSuccess(EditPetSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onEditPetFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).editPet(request);

        awaitForTask(1000);
    }
}
