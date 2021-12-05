package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIEditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.EditUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.EditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class EditUserProfile extends DefaultFailResponseUseCase implements EditUserProfileInputBoundary {
    IUserAPIGateway userAPIGateway;
    EditUserProfileOutputBoundary outputBoundary;

    public EditUserProfile(IUserAPIGateway userAPIGateway, EditUserProfileOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void editUserProfile(EditUserProfileRequestModel request) {
        APIEditUserProfileRequestModel apiRequest = new APIEditUserProfileRequestModel(
                request.getToken(), request.getBiography(),
                request.getInstagram(), request.getFacebook(), request.getPhoneNumber()
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
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new EditUserProfileSuccessResponseModel(
                    dataObj.getString("newBiography"),
                    dataObj.getString("newInstagram"),
                    dataObj.getString("newFacebook"),
                    dataObj.getString("newPhoneNumber")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful edit user profile response.");
        }
    }
}
