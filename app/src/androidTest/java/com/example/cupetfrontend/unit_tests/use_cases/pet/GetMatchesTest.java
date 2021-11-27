package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.GetMatches;
import com.example.cupetfrontend.use_cases.GetPotentialMatches;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.GetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.GetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.response_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetMatchesTest extends UseCaseTestClass {
    @Test
    public void testGetMatchesSuccess(){
        GetMatchesRequestModel request = new GetMatchesRequestModel(
                "dummy token", "dummy pet id");

        new GetMatches(successPetAPIGateway, new GetMatchesOutputBoundary() {
            @Override
            public void onGetMatchesSuccess(GetMatchesSuccessResponseModel response) {
                for (PetData pet : response.getMatches()) {
                    assertEquals(pet.getName(), "dummy name");
                    assertEquals(pet.getAge(), "dummy age");
                    assertEquals(pet.getBreed(), "dummy breed");
                    assertEquals(pet.getBiography(), "dummy biography");
                }

                setTaskComplete();
            }

            @Override
            public void onGetMatchesFailure(GetMatchesFailResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).getMatches(request);

        awaitForTask(1000);
    }

    @Test
    public void testGetMatchesFailure(){
        GetMatchesRequestModel request = new GetMatchesRequestModel(
                "dummy token", "dummy pet id");

        new GetMatches(failurePetAPIGateway, new GetMatchesOutputBoundary() {
            @Override
            public void onGetMatchesSuccess(GetMatchesSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onGetMatchesFailure(GetMatchesFailResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).getMatches(request);

        awaitForTask(1000);
    }
}
