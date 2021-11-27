package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetPotentialMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPetDataListOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.GetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.response_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GetPotentialMatches extends UsesPetDataWrapper implements GetPotentialMatchesInputBoundary {
    IPetAPIGateway petAPIGateway;
    GetPotentialMatchesOutputBoundary outputBoundary;

    public GetPotentialMatches(IPetAPIGateway petAPIGateway, GetPotentialMatchesOutputBoundary outputBoundary) {
        super(petAPIGateway);
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getPotentialMatches(GetPotentialMatchesRequestModel request) {
        APIGetPotentialMatchesRequestModel apiRequest = new APIGetPotentialMatchesRequestModel(
                request.getToken(), request.getPetId()
        );

        petAPIGateway.getPotentialMatches(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                getPetDataList(request.getToken(), jsonResponse, new GetPetDataListOutputBoundary() {
                    @Override
                    public void onGetPetDataListSuccess(List<PetData> petDataList) {
                        outputBoundary.onGetPotentialMatchesSuccess(new GetPotentialMatchesSuccessResponseModel(
                                petDataList
                        ));
                    }

                    @Override
                    public void onGetPetDataListFailure(String errorMessage) {
                        outputBoundary.onGetPotentialMatchesFailure(new GetPotentialMatchesFailResponseModel(
                                errorMessage
                        ));
                    }
                });
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onGetPotentialMatchesFailure(toFailResponseModel(jsonResponse));
            }
        });
    }

    /**
     * Convert a JSONObject response to an instance of
     * PetCreatorFailResponseModel.
     *
     * @param jsonResponse A JSON representation of the response.
     * @return The response as a PetCreatorFailResponseModel
     */
    private GetPotentialMatchesFailResponseModel toFailResponseModel(JSONObject jsonResponse) {
        try {
            return new GetPotentialMatchesFailResponseModel(jsonResponse.getString("message"));
        } catch (JSONException e) {
            throw new InvalidAPIResponseException("The API gave an invalid fail intend to match response");
        }
    }
}
