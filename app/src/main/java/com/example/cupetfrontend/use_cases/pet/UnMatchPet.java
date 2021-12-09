package com.example.cupetfrontend.use_cases.pet;

import com.example.cupetfrontend.use_cases.DefaultFailResponseUseCase;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIUnMatchPetRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.UnMatchPetInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.UnMatchPetOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.UnMatchPetRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.UnMatchPetSuccessResponseModel;

import org.json.JSONObject;

public class UnMatchPet extends DefaultFailResponseUseCase implements UnMatchPetInputBoundary {
    IPetAPIGateway petAPIGateway;
    UnMatchPetOutputBoundary outputBoundary;

    public UnMatchPet(IPetAPIGateway petAPIGateway, UnMatchPetOutputBoundary outputBoundary) {
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void unMatchPet(UnMatchPetRequestModel request) {
        APIUnMatchPetRequestModel apiRequest = new APIUnMatchPetRequestModel(
                request.getToken(), request.getMyPetId(), request.getOtherPetId()
        );
//
        petAPIGateway.unMatchPet(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                outputBoundary.onUnMatchPetSuccess(toSuccessResponseModel(jsonResponse));
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onUnMatchPetFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * UnMatchPetSuccessResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a PetCreatorSuccessResponseModel
     */
    private UnMatchPetSuccessResponseModel toSuccessResponseModel(JSONObject jsonResponse) {
        return new UnMatchPetSuccessResponseModel();
    }
}
