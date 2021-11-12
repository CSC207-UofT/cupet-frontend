package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APIFetchUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.FetchUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.FetchUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchUserProfileSuccessResponseModel;
import org.json.JSONObject;

public class FetchUserProfile implements FetchUserProfileInputBoundary {
    IUserAPIGateway userAPIGateway;
    FetchUserProfileOutputBoundary outputBoundary;

    public FetchUserProfile(IUserAPIGateway userAPIGateway, FetchUserProfileOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchUserProfile(FetchUserProfileRequestModel request) {
        APIFetchUserProfileRequestModel apiRequest = new APIFetchUserProfileRequestModel(
                request.getToken(), request.getUserId()
        );

        userAPIGateway.fetchUserProfile(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onFetchUserProfileSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onFetchUserProfileFailure(toFailResponseModel(jsonResponse));
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
    private FetchUserProfileSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        // TODO: Waiting on backend implementation
//        try {
        return new FetchUserProfileSuccessResponseModel(
                "a", "b", "c");
//        } catch (JSONException e) {
//            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
//        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * FetchPetProfileFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a FetchPetProfileFailResponseModel
     */
    private FetchUserProfileFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new FetchUserProfileFailResponseModel("Sample Error Message");
    }
}
