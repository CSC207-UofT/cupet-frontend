package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIGetPetsRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.GetPetsInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.GetPetsRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.GetPetsFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.GetPetsSuccessResponseModel;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetPets implements GetPetsInputBoundary {
    IUserAPIGateway userAPIGateway;
    GetPetsOutputBoundary outputBoundary;

    public GetPets(IUserAPIGateway userAPIGateway, GetPetsOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getPets(GetPetsRequestModel request) {
        APIGetPetsRequestModel apiRequest = new APIGetPetsRequestModel(
                request.getToken()
        );

        userAPIGateway.getPets(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onGetPetsSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onGetPetsFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * GetPetsSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a GetPetsSuccessResponseModel
     */
    private GetPetsSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        // TODO: Waiting on backend implementation
//        try {
        return new GetPetsSuccessResponseModel(new ArrayList<>());
//        } catch (JSONException e) {
//            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
//        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * GetPetsFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a GetPetsFailResponseModel
     */
    private GetPetsFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new GetPetsFailResponseModel("Sample Error Message");
    }
}
