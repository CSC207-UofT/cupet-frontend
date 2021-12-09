package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A use-class superclass representing a use-case which returns an instance
 * of DefaultFailureResponseModel on all failed requests.
 */
public class DefaultFailResponseUseCase {
    /**
     * Convert a JSONObject response to an instance of
     * DefaultFailureResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a DefaultFailureResponseModel
     */
    public DefaultFailureResponseModel toFailResponseModel(JSONObject jsonResponse) {
        try {
            return new DefaultFailureResponseModel(jsonResponse.getString("message"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid error response");
        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * DefaultFailureResponseModel.
     *
     * @param errorMessage The error message
     * @return The response as a DefaultFailureResponseModel
     */
    public DefaultFailureResponseModel toFailResponseModel(String errorMessage) {
        return new DefaultFailureResponseModel(errorMessage);
    }
}
