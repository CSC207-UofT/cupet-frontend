package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.RemoveFromPetImageGalleryRequestModel;

public interface RemoveFromPetImageGalleryInputBoundary {
    /**
     * Remove an image from a pet's image gallery.
     *
     * @param request The request data
     */
    void removeFromPetImageGallery(RemoveFromPetImageGalleryRequestModel request);
}
