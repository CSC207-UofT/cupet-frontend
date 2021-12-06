package com.example.cupetfrontend.use_cases.pet;

import com.example.cupetfrontend.use_cases.DefaultFailResponseUseCase;
import com.example.cupetfrontend.use_cases.InvalidAPIResponseException;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIAddToPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.AddToPetImageGalleryInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.AddToPetImageGalleryOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.AddToPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.AddToPetImageGallerySuccessResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

public class AddToPetImageGallery extends DefaultFailResponseUseCase
        implements AddToPetImageGalleryInputBoundary {
    IPetAPIGateway petAPIGateway;
    AddToPetImageGalleryOutputBoundary outputBoundary;

    public AddToPetImageGallery(IPetAPIGateway petAPIGateway, AddToPetImageGalleryOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void addToPetImageGallery(AddToPetImageGalleryRequestModel request) {
        APIAddToPetImageGalleryRequestModel apiRequest = new APIAddToPetImageGalleryRequestModel(
                request.getToken(), request.getPetId(), request.getImgB64()
        );

        petAPIGateway.addToPetImageGallery(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onAddToPetImageGallerySuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onAddToPetImageGalleryFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * AddToPetImageGallerySuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a AddToPetImageGallerySuccessResponseModel
     */
    private AddToPetImageGallerySuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new AddToPetImageGallerySuccessResponseModel(
                    dataObj.getString("url")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful add to pet image gallery response.");
        }
    }
}
