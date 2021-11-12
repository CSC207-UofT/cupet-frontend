package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APIGetPetsRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.GetPetsInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.GetPetsRequestModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.GetPetsFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.GetPetsSuccessResponseModel;
import org.json.JSONObject;

import java.sql.Array;
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
