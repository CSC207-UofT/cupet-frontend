package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.PetCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.PetCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;
import org.json.JSONException;
import org.json.JSONObject;

public class PetCreator extends DefaultFailResponseUseCase implements PetCreatorInputBoundary {
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
            JSONObject dataObj = new JSONObject(jsonResponse.getString("data"));

            return new PetCreatorSuccessResponseModel(
                    dataObj.getString("name"),
                    dataObj.getString("age"),
                    dataObj.getString("breed"),
                    dataObj.getString("biography"),
                    dataObj.getString("petId")
                    );
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid successful create pet response.");
        }
    }
}
