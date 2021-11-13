package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIRejectMatchRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.RejectMatchInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.RejectMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.RejectMatchRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RejectMatchFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.RejectMatchSuccessResponseModel;
import org.json.JSONObject;

import java.util.ArrayList;

public class RejectMatch implements RejectMatchInputBoundary {
    IPetAPIGateway petAPIGateway;
    RejectMatchOutputBoundary outputBoundary;

    public RejectMatch(IPetAPIGateway petAPIGateway, RejectMatchOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void rejectMatch(RejectMatchRequestModel request) {
        APIRejectMatchRequestModel apiRequest = new APIRejectMatchRequestModel(
                request.getToken(), request.getMyPetId(), request.getOtherPetId()
        );

        petAPIGateway.rejectMatch(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onRejectMatchSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onRejectMatchFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * PetCreatorSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a PetCreatorSuccessResponseModel
     */
    private RejectMatchSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
//        try {
        return new RejectMatchSuccessResponseModel();
//        } catch (JSONException e) {
//            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
//        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * PetCreatorFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a PetCreatorFailResponseModel
     */
    private RejectMatchFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new RejectMatchFailResponseModel("Sample Error Message");
    }
}
