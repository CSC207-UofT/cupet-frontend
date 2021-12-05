package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIEditUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.EditUserAccountInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.user.EditUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserAccountSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class EditUserAccount extends DefaultFailResponseUseCase implements EditUserAccountInputBoundary {
    IUserAPIGateway userAPIGateway;
    EditUserAccountOutputBoundary outputBoundary;

    public EditUserAccount(IUserAPIGateway userAPIGateway, EditUserAccountOutputBoundary outputBoundary) {
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void editUserAccount(EditUserAccountRequestModel request) {
        APIEditUserAccountRequestModel apiRequest = new APIEditUserAccountRequestModel(
                request.getToken(), request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(), request.getHomeAddress(),
                request.getCity()
        );

        userAPIGateway.editUserAccount(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onEditUserAccountSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onEditUserAccountFailure(toFailResponseModel(jsonResponse));
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
    private EditUserAccountSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new EditUserAccountSuccessResponseModel(
                    dataObj.getString("newFirstName"),
                    dataObj.getString("newLastName"),
                    dataObj.getString("newEmail"),
                    dataObj.getString("newCurrentAddress"),
                    dataObj.getString("newCurrentCity")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful edit user account response.");
        }
    }
}
