package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIEditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.EditUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.EditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileSuccessResponseModel;
import org.json.JSONObject;

public class EditUserProfile implements EditUserProfileInputBoundary {
    IUserAPIGateway userAPIGateway;
    EditUserProfileOutputBoundary outputBoundary;

    public EditUserProfile(IUserAPIGateway userAPIGateway, EditUserProfileOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void editUserProfile(EditUserProfileRequestModel request) {
        APIEditUserProfileRequestModel apiRequest = new APIEditUserProfileRequestModel(
                request.getToken(), request.getNewBiography()
        );

        userAPIGateway.editUserProfile(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onEditUserProfileSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onEditUserProfileFailure(toFailResponseModel(jsonResponse));
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
    private EditUserProfileSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        // TODO: Waiting on backend implementation
//        try {
        return new EditUserProfileSuccessResponseModel();
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
    private EditUserProfileFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new EditUserProfileFailResponseModel("Sample Error Message");
    }
}
