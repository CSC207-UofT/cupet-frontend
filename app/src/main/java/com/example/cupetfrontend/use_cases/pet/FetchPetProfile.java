package com.example.cupetfrontend.use_cases.pet;

import com.example.cupetfrontend.use_cases.DefaultFailResponseUseCase;
import com.example.cupetfrontend.use_cases.InvalidAPIResponseException;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIFetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.FetchPetProfileInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchPetProfile extends DefaultFailResponseUseCase implements FetchPetProfileInputBoundary {
    IPetAPIGateway petAPIGateway;
    FetchPetProfileOutputBoundary outputBoundary;

    public FetchPetProfile(IPetAPIGateway petAPIGateway, FetchPetProfileOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchPetProfile(FetchPetProfileRequestModel request) {
        APIFetchPetProfileRequestModel apiRequest = new APIFetchPetProfileRequestModel(
                request.getToken(), request.getPetId()
        );

        petAPIGateway.fetchPetProfile(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onFetchPetProfileSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onFetchPetProfileFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * FetchPetProfileSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a FetchPetProfileSuccessResponseModel
     */
    private FetchPetProfileSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new FetchPetProfileSuccessResponseModel(
                    dataObj.getString("name"),
                    dataObj.getString("age"),
                    dataObj.getString("breed"),
                    dataObj.getString("biography"),
                    dataObj.getString("profileImgUrl"),
                    dataObj.getString("userId")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful fetch pet profile response.");
        }
    }
}
