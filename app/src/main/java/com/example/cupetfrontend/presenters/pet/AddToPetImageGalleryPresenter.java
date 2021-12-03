package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.AddToPetImageGalleryOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.AddToPetImageGallerySuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;

public class AddToPetImageGalleryPresenter implements AddToPetImageGalleryOutputBoundary {
    @Override
    public void onAddToPetImageGallerySuccess(AddToPetImageGallerySuccessResponseModel response) {

    }

    @Override
    public void onAddToPetImageGalleryFailure(DefaultFailureResponseModel response) {

    }
}
