package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.pet.FetchPetProfile;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FetchPetProfileTest extends UseCaseTestClass {
    @Test
    public void testFetchPetProfileSuccess(){
        FetchPetProfileRequestModel request = new FetchPetProfileRequestModel(
                "dummy token", "dummy pet id");

        new FetchPetProfile(successPetAPIGateway, new FetchPetProfileOutputBoundary() {
            @Override
            public void onFetchPetProfileSuccess(FetchPetProfileSuccessResponseModel response) {
                assertEquals(response.getName(), "dummy name");
                assertEquals(response.getAge(), "dummy age");
                assertEquals(response.getBreed(), "dummy breed");
                assertEquals(response.getBiography(), "dummy biography");
                assertEquals(response.getProfileImgUrl(), "dummy url");

                setTaskComplete();
            }

            @Override
            public void onFetchPetProfileFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).fetchPetProfile(request);

        awaitForTask(1000);
    }

    @Test
    public void testFetchPetProfileFailure(){
        FetchPetProfileRequestModel request = new FetchPetProfileRequestModel(
                "dummy token", "dummy pet id");

        new FetchPetProfile(failurePetAPIGateway, new FetchPetProfileOutputBoundary() {
            @Override
            public void onFetchPetProfileSuccess(FetchPetProfileSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onFetchPetProfileFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();

            }
        }).fetchPetProfile(request);

        awaitForTask(1000);
    }
}
