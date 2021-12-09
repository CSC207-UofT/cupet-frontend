package com.example.cupetfrontend.use_cases.user;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.APIGetPetsRequestModel;
import com.example.cupetfrontend.use_cases.input_boundaries.user.GetPetsInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPetDataListOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.pet.UsesPetDataWrapper;
import com.example.cupetfrontend.use_cases.request_models.user.GetPetsRequestModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.user.GetPetsSuccessResponseModel;

import org.json.JSONObject;

import java.util.List;

public class GetPets extends UsesPetDataWrapper implements GetPetsInputBoundary {
    IPetAPIGateway petAPIGateway;
    IUserAPIGateway userAPIGateway;
    GetPetsOutputBoundary outputBoundary;

    public GetPets(IPetAPIGateway petAPIGateway, IUserAPIGateway userAPIGateway, GetPetsOutputBoundary outputBoundary) {
        super(petAPIGateway);
        this.userAPIGateway = userAPIGateway;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getPets(GetPetsRequestModel request) {
        APIGetPetsRequestModel apiRequest = new APIGetPetsRequestModel(
                request.getToken()
        );

        userAPIGateway.getPets(apiRequest, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject jsonResponse) {
                getPetDataList(request.getToken(), jsonResponse, new GetPetDataListOutputBoundary() {
                    @Override
                    public void onGetPetDataListSuccess(List<PetData> petDataList) {
                        outputBoundary.onGetPetsSuccess(new GetPetsSuccessResponseModel(
                                petDataList
                        ));
                    }

                    @Override
                    public void onGetPetDataListFailure(String errorMessage) {
                        outputBoundary.onGetPetsFailure(toFailResponseModel(errorMessage));
                    }
                });
            }

            @Override
            public void onRequestError(JSONObject jsonResponse) {
                outputBoundary.onGetPetsFailure(toFailResponseModel(jsonResponse));
            }
        });
    }
}
