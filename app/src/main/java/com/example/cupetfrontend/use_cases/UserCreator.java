package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APICreateUserRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.UserCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.UserCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class UserCreator implements UserCreatorInputBoundary {
    IUserAPIGateway userAPIGateway;
    UserCreatorOutputBoundary outputBoundary;

    public UserCreator(IUserAPIGateway userAPIGateway, UserCreatorOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    public void createUser(UserCreatorRequestModel request) {
        APICreateUserRequestModel apiRequest = new APICreateUserRequestModel(
                request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(), request.getHomeAddress(),
                request.getCity());

        userAPIGateway.createUser(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onCreateUserSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onCreateUserFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * UserCreatorSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a UserCreatorSuccessResponseModel
     */
    private UserCreatorSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {

            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new UserCreatorSuccessResponseModel(
                    dataObj.getString("firstName"),
                    dataObj.getString("lastName"),
                    dataObj.getString("currentAddress"),
                    dataObj.getString("email"),
                    dataObj.getString("currentCity"),
                    dataObj.getString("userId")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * UserCreatorFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a UserCreatorFailResponseModel
     */
    private UserCreatorFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        try {
            return new UserCreatorFailResponseModel(jsonResponse.getString("message"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid failed create user response.");
        }
    }
}
