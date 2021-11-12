package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APIFetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.FetchPetProfileInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.FetchPetProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchPetProfileSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.PetCreatorSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchPetProfile implements FetchPetProfileInputBoundary {
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
            return new FetchPetProfileSuccessResponseModel(
                    jsonResponse.getString("name"),
                    jsonResponse.getString("age"),
                    jsonResponse.getString("breed"),
                    jsonResponse.getString("biography")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * FetchPetProfileFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a FetchPetProfileFailResponseModel
     */
    private FetchPetProfileFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new FetchPetProfileFailResponseModel("Sample Error Message");
    }
}
