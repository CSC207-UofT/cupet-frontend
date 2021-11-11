package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APICreateUserRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.UserCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.UserCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.UserCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.UserCreatorSuccessResponseModel;
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
                request.getEmail(), request.getPassword(), request.getHomeAddress());

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

    private UserCreatorSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            // TODO: The current API does not return a message; include a dummy message
            //  replace with actual message once API is updated
            return new UserCreatorSuccessResponseModel(
                    "temp_message",
                    jsonResponse.getString("firstName"),
                    jsonResponse.getString("lastName"),
                    jsonResponse.getString("homeAddress"),
                    jsonResponse.getString("email"),
                    jsonResponse.getString("userId")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
        }
    }

    private UserCreatorFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new UserCreatorFailResponseModel("Sample Error Message");
    }
}
