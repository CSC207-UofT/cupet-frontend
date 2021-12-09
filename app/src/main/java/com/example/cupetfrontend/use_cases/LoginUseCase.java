package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APILoginRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.LoginInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.LoginRequestModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginUseCase extends DefaultFailResponseUseCase implements LoginInputBoundary {

    IAuthAPIGateway authAPIGateway;
    LoginOutputBoundary outputBoundary;

    public LoginUseCase(IAuthAPIGateway authAPIGateway, LoginOutputBoundary outputBoundary) {
        this.authAPIGateway = authAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void login(LoginRequestModel request) {
        APILoginRequestModel apiRequest = new APILoginRequestModel(request.getEmail(), request.getPassword());

        authAPIGateway.login(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                // TODO: Remove temporary code
                //  The API currently does not support HTTP status codes, so we need this
                //  code to prevent a runtime exception from crashing the application

                try {
                    if (jsonResponse.get("isSuccess").equals("true")) {
                        outputBoundary.onLoginSuccess(toSuccessResponseModel(jsonResponse));
                    } else {
                        outputBoundary.onLoginFailure(toFailResponseModel(jsonResponse));
                    }
                } catch (JSONException e) {
                    throw new InvalidAPIResponseException(
                            "The API gave an invalid login response:" + jsonResponse);
                }

                // TODO: Uncomment when API is updated.
//                outputBoundary.onLoginSuccess(toSuccessResponseModel(jsonResponse));
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
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));
            return new LoginSuccessResponseModel(dataObj.getString("jwt"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful login response:" + jsonResponse);
        }
    }
}
