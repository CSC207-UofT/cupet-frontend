package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.GetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetMatches implements GetMatchesInputBoundary {
    IPetAPIGateway petAPIGateway;
    GetMatchesOutputBoundary outputBoundary;

    public GetMatches(IPetAPIGateway petAPIGateway, GetMatchesOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getMatches(GetMatchesRequestModel request) {
        APIGetMatchesRequestModel apiRequest = new APIGetMatchesRequestModel(
                request.getToken(), request.getMyPetId()
        );

        petAPIGateway.getMatches(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onGetMatchesSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onGetMatchesFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * GetMatchesSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a GetMatchesSuccessResponseModel
     */
    private GetMatchesSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
//        try {
            return new GetMatchesSuccessResponseModel(
                    new ArrayList<>()
            );
//        } catch (JSONException e) {
//            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
//        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * GetMatchesFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a GetMatchesFailResponseModel
     */
    private GetMatchesFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new GetMatchesFailResponseModel("Sample Error Message");
    }
}
