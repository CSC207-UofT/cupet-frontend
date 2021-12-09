package com.example.cupetfrontend.use_cases.pet;

import com.example.cupetfrontend.use_cases.DefaultFailResponseUseCase;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIRemoveFromPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.RemoveFromPetImageGalleryInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.RemoveFromPetImageGalleryOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.RemoveFromPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RemoveFromPetImageGallerySuccessResponseModel;

import org.json.JSONObject;

public class RemoveFromPetImageGallery extends DefaultFailResponseUseCase implements RemoveFromPetImageGalleryInputBoundary {
    IPetAPIGateway petAPIGateway;
    RemoveFromPetImageGalleryOutputBoundary outputBoundary;

    public RemoveFromPetImageGallery(IPetAPIGateway petAPIGateway, RemoveFromPetImageGalleryOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void removeFromPetImageGallery(RemoveFromPetImageGalleryRequestModel request) {
        APIRemoveFromPetImageGalleryRequestModel apiRequest = new APIRemoveFromPetImageGalleryRequestModel(
                request.getToken(), request.getPetId(), request.getAssetId()
        );

        petAPIGateway.removeFromPetImageGallery(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onRemoveFromPetImageGallerySuccess(
                        toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onRemoveFromPetImageGalleryFailure(
                        toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * RemoveFromPetImageGallerySuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a RemoveFromPetImageGallerySuccessResponseModel
     */
    private RemoveFromPetImageGallerySuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        return new RemoveFromPetImageGallerySuccessResponseModel();
    }
}
