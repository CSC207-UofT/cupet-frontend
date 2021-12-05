package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIAddToPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APISetPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.SetPetProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.AddToPetImageGalleryOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.SetPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.AddToPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.SetPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.AddToPetImageGallerySuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.SetPetProfileImageSuccessResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

public class SetPetProfileImage extends DefaultFailResponseUseCase implements SetPetProfileImageInputBoundary {
    IPetAPIGateway petAPIGateway;
    SetPetProfileImageOutputBoundary outputBoundary;

    public SetPetProfileImage(IPetAPIGateway petAPIGateway, SetPetProfileImageOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void setPetProfileImage(SetPetProfileImageRequestModel request) {
        APISetPetProfileImageRequestModel apiRequest = new APISetPetProfileImageRequestModel(
                request.getToken(), request.getPetId(), request.getImgB64()
        );

        petAPIGateway.setPetProfileImage(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onSetPetProfileImageSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onSetPetProfileImageFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * SetPetProfileImageSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a SetPetProfileImageSuccessResponseModel
     */
    private SetPetProfileImageSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new SetPetProfileImageSuccessResponseModel(
                    dataObj.getString("url")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful set pet profile image response.");
        }
    }
}
