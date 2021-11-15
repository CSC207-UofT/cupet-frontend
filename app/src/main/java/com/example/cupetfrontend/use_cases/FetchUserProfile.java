package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIFetchUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;
import org.json.JSONException;
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
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new FetchUserProfileSuccessResponseModel(
                    dataObj.getString("firstName"),
                    dataObj.getString("lastName"),
                    dataObj.getString("biography"),
                    dataObj.getString("instagram"),
                    dataObj.getString("facebook"),
                    dataObj.getString("phoneNumber")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful fetch user profile response.");
        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * FetchPetProfileFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a FetchPetProfileFailResponseModel
     */
    private FetchUserProfileFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        try {
            return new FetchUserProfileFailResponseModel(jsonResponse.getString("message"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid fail fetch user response");
        }
    }
}
