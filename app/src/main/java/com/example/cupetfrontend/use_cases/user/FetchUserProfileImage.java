package com.example.cupetfrontend.use_cases.user;

import com.example.cupetfrontend.use_cases.DefaultFailResponseUseCase;
import com.example.cupetfrontend.use_cases.InvalidAPIResponseException;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIFetchUserProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserProfileImageSuccessResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

public class FetchUserProfileImage extends DefaultFailResponseUseCase implements FetchUserProfileImageInputBoundary {
    IUserAPIGateway userAPIGateway;
    FetchUserProfileImageOutputBoundary outputBoundary;

    public FetchUserProfileImage(IUserAPIGateway userAPIGateway, FetchUserProfileImageOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchUserProfileImage(FetchUserProfileImageRequestModel request) {
        APIFetchUserProfileImageRequestModel apiRequest = new APIFetchUserProfileImageRequestModel(
                request.getToken(), request.getUserId()
        );

        userAPIGateway.fetchUserProfileImage(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onFetchUserProfileImageSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onFetchUserProfileImageFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * FetchUserProfileImageSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a FetchUserProfileImageSuccessResponseModel
     */
    private UserProfileImageSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new UserProfileImageSuccessResponseModel(
                    dataObj.getString("url")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful" +
                    " fetch user profile image response.");
        }
    }
}
