package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APILoginRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.LoginInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.LoginRequestModel;
import com.example.cupetfrontend.use_cases.response_models.LoginFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginUseCase implements LoginInputBoundary {

    IAuthAPIGateway authAPIGateway;
    LoginOutputBoundary outputBoundary;

    public LoginUseCase(IAuthAPIGateway authAPIGateway) {
        this.authAPIGateway = authAPIGateway;
    }

    @Override
    public void login(LoginRequestModel request) {
        APILoginRequestModel apiRequest = new APILoginRequestModel(request.getEmail(), request.getPassword());

        authAPIGateway.login(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onLoginSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onLoginFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * LoginSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a LoginSuccessResponseModel
     */
    private LoginSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            return new LoginSuccessResponseModel(jsonResponse.getString("token"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * LoginFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a LoginFailResponseModel
     */
    private LoginFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new LoginFailResponseModel("dummy_message");
    }
}
