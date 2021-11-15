package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIFetchUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserAccountInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;
import org.json.JSONException;
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
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new FetchUserAccountSuccessResponseModel(
                    dataObj.getString("firstName"),
                    dataObj.getString("lastName"),
                    dataObj.getString("currentAddress"),
                    dataObj.getString("currentCity"),
                    dataObj.getString("email")
                    );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful fetch user response.");
        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * FetchPetProfileFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a FetchPetProfileFailResponseModel
     */
    private FetchUserAccountFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        try {
            return new FetchUserAccountFailResponseModel(jsonResponse.getString("message"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid fail fetch user response");
        }
    }
}
