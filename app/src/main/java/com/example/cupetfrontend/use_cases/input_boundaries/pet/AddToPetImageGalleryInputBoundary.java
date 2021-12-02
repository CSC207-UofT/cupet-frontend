package com.example.cupetfrontend.use_cases.input_boundaries.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.AddToPetImageGalleryRequestModel;

public interface AddToPetImageGalleryInputBoundary {
    /**
     * Add an image to a pet's image gallery.
     * @param request The request data
     */
    void addToPetImageGallery(AddToPetImageGalleryRequestModel request);
}
