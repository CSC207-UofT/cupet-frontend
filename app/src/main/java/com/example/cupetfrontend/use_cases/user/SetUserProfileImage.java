package com.example.cupetfrontend.use_cases.user;

import com.example.cupetfrontend.use_cases.DefaultFailResponseUseCase;
import com.example.cupetfrontend.use_cases.InvalidAPIResponseException;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APISetUserProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.SetUserProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.SetUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.SetUserProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.SetUserProfileImageSuccessResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

public class SetUserProfileImage extends DefaultFailResponseUseCase implements SetUserProfileImageInputBoundary {
    IUserAPIGateway userAPIGateway;
    SetUserProfileImageOutputBoundary outputBoundary;

    public SetUserProfileImage(IUserAPIGateway userAPIGateway, SetUserProfileImageOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }


    @Override
    public void setUserProfileImage(SetUserProfileImageRequestModel request) {
        APISetUserProfileImageRequestModel apiRequest = new APISetUserProfileImageRequestModel(
                request.getToken(), request.getImgB64()
        );

        userAPIGateway.setUserProfileImage(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onSetUserProfileImageSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onSetUserProfileImageFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * SetUserProfileImageSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a SetUserProfileImageSuccessResponseModel
     */
    private SetUserProfileImageSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new SetUserProfileImageSuccessResponseModel(
                    dataObj.getString("url")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful set user profile image response.");
        }
    }
}
