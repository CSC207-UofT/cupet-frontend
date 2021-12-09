package com.example.cupetfrontend.use_cases.pet;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPetDataListOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.GetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;

import org.json.JSONObject;

import java.util.List;

public class GetMatches extends UsesPetDataWrapper implements GetMatchesInputBoundary {
    IPetAPIGateway petAPIGateway;
    GetMatchesOutputBoundary outputBoundary;

    public GetMatches(IPetAPIGateway petAPIGateway, GetMatchesOutputBoundary outputBoundary) {
        super(petAPIGateway);
        this.petAPIGateway = petAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getMatches(GetMatchesRequestModel request) {
        APIGetMatchesRequestModel apiRequest = new APIGetMatchesRequestModel(
                request.getToken(), request.getPetId()
        );

        petAPIGateway.getMatches(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                getPetDataList(request.getToken(), jsonResponse, new GetPetDataListOutputBoundary() {
                    @Override
                    public void onGetPetDataListSuccess(List<PetData> petDataList) {
                        outputBoundary.onGetMatchesSuccess(new GetMatchesSuccessResponseModel(
                                petDataList
                        ));
                    }

                    @Override
                    public void onGetPetDataListFailure(String errorMessage) {
                        outputBoundary.onGetMatchesFailure(toFailResponseModel(errorMessage));
                    }
                });
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onGetMatchesFailure(toFailResponseModel(jsonResponse));
            }
        });
    }
}
