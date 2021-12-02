package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIFetchPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.FetchPetProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetProfileImageSuccessResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

public class FetchPetProfileImage extends DefaultFailResponseUseCase implements FetchPetProfileImageInputBoundary {
    IPetAPIGateway petAPIGateway;
    FetchPetProfileImageOutputBoundary outputBoundary;

    public FetchPetProfileImage(IPetAPIGateway petAPIGateway,
                                FetchPetProfileImageOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchPetProfileImage(FetchPetProfileImageRequestModel request) {
        APIFetchPetProfileImageRequestModel apiRequest = new APIFetchPetProfileImageRequestModel(
                request.getToken(), request.getPetId()
        );

        petAPIGateway.fetchPetProfileImage(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onFetchPetProfileImageSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onFetchPetProfileImageFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * FetchPetProfileImageSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a FetchPetProfileImageSuccessResponseModel
     */
    private PetProfileImageSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new PetProfileImageSuccessResponseModel(
                    dataObj.getString("url")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful" +
                    " fetch pet profile image response.");
        }
    }
}
