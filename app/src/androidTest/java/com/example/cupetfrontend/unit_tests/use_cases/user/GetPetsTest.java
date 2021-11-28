package com.example.cupetfrontend.unit_tests.use_cases.user;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.GetPets;
import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.GetPetsRequestModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.GetPetsSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetPetsTest extends UseCaseTestClass {
    @Test
    public void testGetPetsSuccess(){
        GetPetsRequestModel request = new GetPetsRequestModel(
                "dummy token");

        new GetPets(successPetAPIGateway, successUserAPIGateway, new GetPetsOutputBoundary() {
            @Override
            public void onGetPetsSuccess(GetPetsSuccessResponseModel response) {
                for (PetData pet : response.getPets()){
                    assertEquals(pet.getName(), "dummy name");
                    assertEquals(pet.getAge(), "dummy age");
                    assertEquals(pet.getBreed(), "dummy breed");
                    assertEquals(pet.getBiography(), "dummy biography");
                }

                setTaskComplete();
            }

            @Override
            public void onGetPetsFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).getPets(request);

        awaitForTask(1000);
    }

    @Test
    public void testGetPetsFailure(){
        GetPetsRequestModel request = new GetPetsRequestModel(
                "dummy token");

        new GetPets(failurePetAPIGateway, failureUserAPIGateway, new GetPetsOutputBoundary() {
            @Override
            public void onGetPetsSuccess(GetPetsSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onGetPetsFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).getPets(request);

        awaitForTask(1000);
    }
}
