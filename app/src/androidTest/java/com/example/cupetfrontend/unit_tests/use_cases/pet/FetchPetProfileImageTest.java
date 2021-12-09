package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.pet.FetchPetProfileImage;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetProfileImageSuccessResponseModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FetchPetProfileImageTest extends UseCaseTestClass {
    @Test
    public void testFetchPetProfileImageSuccess(){
        FetchPetProfileImageRequestModel request = new FetchPetProfileImageRequestModel(
                "dummy token", "dummy pet id");

        new FetchPetProfileImage(successPetAPIGateway, new FetchPetProfileImageOutputBoundary() {
            @Override
            public void onFetchPetProfileImageSuccess(PetProfileImageSuccessResponseModel response) {
                assertEquals(response.getImgUrl(), "dummy url");
                setTaskComplete();
            }

            @Override
            public void onFetchPetProfileImageFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).fetchPetProfileImage(request);

        awaitForTask(1000);
    }

    @Test
    public void testFetchPetProfileImageFailure(){
        FetchPetProfileImageRequestModel request = new FetchPetProfileImageRequestModel(
                "dummy token", "dummy pet id");

        new FetchPetProfileImage(failurePetAPIGateway, new FetchPetProfileImageOutputBoundary() {
            @Override
            public void onFetchPetProfileImageSuccess(PetProfileImageSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onFetchPetProfileImageFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).fetchPetProfileImage(request);

        awaitForTask(1000);
    }
}
