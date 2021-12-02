package com.example.cupetfrontend.unit_tests.use_cases.pet;

import com.example.cupetfrontend.unit_tests.use_cases.UseCaseTestClass;
import com.example.cupetfrontend.use_cases.SetPetProfileImage;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.SetPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.SetPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.SetPetProfileImageSuccessResponseModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SetPetProfileImageTest extends UseCaseTestClass {
    @Test
    public void testSetPetProfileImageSuccess(){
        SetPetProfileImageRequestModel request = new SetPetProfileImageRequestModel(
                "dummy token", "dummy pet id", "dummy image b64");

        new SetPetProfileImage(successPetAPIGateway, new SetPetProfileImageOutputBoundary() {
            @Override
            public void onSetPetProfileImageSuccess(SetPetProfileImageSuccessResponseModel response) {
                assertEquals(response.getImgUrl(), "dummy url");
                setTaskComplete();
            }

            @Override
            public void onSetPetProfileImageFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).setPetProfileImage(request);

        awaitForTask(1000);
    }

    @Test
    public void testSetPetProfileImageFailure(){
        SetPetProfileImageRequestModel request = new SetPetProfileImageRequestModel(
                "dummy token", "dummy pet id", "dummy image b64");

        new SetPetProfileImage(failurePetAPIGateway, new SetPetProfileImageOutputBoundary() {
            @Override
            public void onSetPetProfileImageSuccess(SetPetProfileImageSuccessResponseModel response) {
                fail("Request incorrectly succeeded");
            }

            @Override
            public void onSetPetProfileImageFailure(DefaultFailureResponseModel response) {
                assertEquals(response.getErrorMessage(), "dummy error message");

                setTaskComplete();
            }
        }).setPetProfileImage(request);

        awaitForTask(1000);
    }
}
