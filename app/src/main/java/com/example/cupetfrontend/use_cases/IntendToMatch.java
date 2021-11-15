package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIIntendToMatchRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.IntendToMatchInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.IntendToMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.IntendToMatchRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class IntendToMatch implements IntendToMatchInputBoundary {
    IPetAPIGateway petAPIGateway;
    IntendToMatchOutputBoundary outputBoundary;

    public IntendToMatch(IPetAPIGateway petAPIGateway, IntendToMatchOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void intendToMatch(IntendToMatchRequestModel request) {
        APIIntendToMatchRequestModel apiRequest = new APIIntendToMatchRequestModel(
                request.getToken(), request.getMyPetId(), request.getOtherPetId()
        );

        petAPIGateway.intendToMatch(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onIntendToMatchSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onIntendToMatchFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * IntendToMatchSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a IntendToMatchSuccessResponseModel
     */
    private IntendToMatchSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        return new IntendToMatchSuccessResponseModel();
    }

    /**
     * Convert a JSONObject response to an instance of
     * IntendToMatchFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a IntendToMatchFailResponseModel
     */
    private IntendToMatchFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        try {
            return new IntendToMatchFailResponseModel(jsonResponse.getString("message"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid fail intend to match response");
        }
    }
}
