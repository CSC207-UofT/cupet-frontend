package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetPotentialMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.GetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetPotentialMatches implements GetPotentialMatchesInputBoundary {
    IPetAPIGateway petAPIGateway;
    GetPotentialMatchesOutputBoundary outputBoundary;

    public GetPotentialMatches(IPetAPIGateway petAPIGateway, GetPotentialMatchesOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getPotentialMatches(GetPotentialMatchesRequestModel request) {
        APIGetPotentialMatchesRequestModel apiRequest = new APIGetPotentialMatchesRequestModel(
                request.getToken(), request.getPetId()
        );

        petAPIGateway.getPotentialMatches(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onGetPotentialMatchesSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onGetPotentialMatchesFailure(toFailResponseModel(jsonResponse));
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
    private GetPotentialMatchesSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
//        try {
            return new GetPotentialMatchesSuccessResponseModel(new ArrayList<>());
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
    private GetPotentialMatchesFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new GetPotentialMatchesFailResponseModel("Sample Error Message");
    }
}
