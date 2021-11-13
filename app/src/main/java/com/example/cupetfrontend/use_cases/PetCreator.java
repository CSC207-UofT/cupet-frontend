package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.PetCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.PetCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class PetCreator implements PetCreatorInputBoundary {
    IPetAPIGateway petAPIGateway;
    PetCreatorOutputBoundary outputBoundary;

    public PetCreator(IPetAPIGateway petAPIGateway, PetCreatorOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void createPet(PetCreatorRequestModel request) {
        APICreatePetRequestModel apiRequest = new APICreatePetRequestModel(
               request.getToken(), request.getName(), request.getAge(), request.getBreed(), request.getBiography()
        );

        petAPIGateway.createPet(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onCreatePetSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onCreatePetFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * PetCreatorSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a PetCreatorSuccessResponseModel
     */
    private PetCreatorSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        try {
            return new PetCreatorSuccessResponseModel(
                    jsonResponse.getString("name"),
                    jsonResponse.getString("age"),
                    jsonResponse.getString("name"),
                    jsonResponse.getString("age"),
                    jsonResponse.getString("age")
            );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful create user response.");
        }
    }

    /**
     * Convert a JSONObject response to an instance of
     * PetCreatorFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a PetCreatorFailResponseModel
     */
    private PetCreatorFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        // TODO: The current API does not return a message; include a dummy message
        //  replace with actual message once API is updated
        return new PetCreatorFailResponseModel("Sample Error Message");
    }
}
