package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APIFetchUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.FetchUserAccountInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.FetchUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.EditUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.FetchUserAccountSuccessResponseModel;
import org.json.JSONObject;

public class FetchUserAccount implements FetchUserAccountInputBoundary {
    IUserAPIGateway userAPIGateway;
    FetchUserAccountOutputBoundary outputBoundary;

    public FetchUserAccount(IUserAPIGateway userAPIGateway, FetchUserAccountOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchUserAccount(FetchUserAccountRequestModel request) {
        APIFetchUserAccountRequestModel apiRequest = new APIFetchUserAccountRequestModel(
                request.getToken()
        );

        userAPIGateway.fetchUserAccount(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onFetchUserAccountSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onFetchUserAccountFailure(toFailResponseModel(jsonResponse));
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
    private FetchUserAccountSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        // TODO: Waiting on backend implementation
//        try {
        return new FetchUserAccountSuccessResponseModel("dummy first",
                "dummy last", "dummy email", "dummy home address",
                "dummy city");
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
    private FetchUserAccountFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new FetchUserAccountFailResponseModel("Sample Error Message");
    }
}
