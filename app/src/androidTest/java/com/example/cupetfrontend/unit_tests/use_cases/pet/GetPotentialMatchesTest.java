package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.pet.GetPotentialMatches;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.GetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetPotentialMatchesTest extends UseCaseTestClass {
    @Test
    public void testGetPotentialMatchesSuccess(){
        GetPotentialMatchesRequestModel request = new GetPotentialMatchesRequestModel(
                "dummy token", "dummy pet id");

        new GetPotentialMatches(successPetAPIGateway, new GetPotentialMatchesOutputBoundary() {
            @Override
            public void onGetPotentialMatchesSuccess(GetPotentialMatchesSuccessResponseModel response) {
                for (PetData pet : response.getPotentialMatches()){
                    assertEquals(pet.getName(), "dummy name");
                    assertEquals(pet.getAge(), "dummy age");
                    assertEquals(pet.getBreed(), "dummy breed");
                    assertEquals(pet.getBiography(), "dummy biography");
                    assertEquals(pet.getProfileImgUrl(), "dummy url");
                }

                setTaskComplete();
            }

            @Override
            public void onGetPotentialMatchesFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).getPotentialMatches(request);

        awaitForTask(1000);
    }

    @Test
    public void testGetPotentialMatchesFailure(){
        GetPotentialMatchesRequestModel request = new GetPotentialMatchesRequestModel(
                "dummy token", "dummy pet id");

        new GetPotentialMatches(failurePetAPIGateway, new GetPotentialMatchesOutputBoundary() {
            @Override
            public void onGetPotentialMatchesSuccess(GetPotentialMatchesSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onGetPotentialMatchesFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).getPotentialMatches(request);

        awaitForTask(1000);
    }
}
