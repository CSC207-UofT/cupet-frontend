package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.use_cases.output_boundaries.pet.RemoveFromPetImageGalleryOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RemoveFromPetImageGallerySuccessResponseModel;

public class RemoveFromPetImageGalleryPresenter implements RemoveFromPetImageGalleryOutputBoundary {
    @Override
    public void onRemoveFromPetImageGallerySuccess(RemoveFromPetImageGallerySuccessResponseModel response) {

    }

    @Override
    public void onRemoveFromPetImageGalleryFailure(DefaultFailureResponseModel response) {

    }
}
