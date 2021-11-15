package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPetDataListOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.response_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileSuccessResponseModel;

import java.util.List;

/**
 * A helper use case class responsible for converting a list of pet ids
 * to a list of PetData.
 *
 * NOTE: This class should be re-constructed each time this conversion is made.
 */
public class GetPetDataList {
    private List<PetData> petDataList;
    private List<String> petIds;
    private final FetchPetProfile fetchPetProfile;
    private final String token;
    private int currentIndex;
    private GetPetDataListOutputBoundary outputBoundary;

    public GetPetDataList(String token, IPetAPIGateway petAPIGateway,
                          GetPetDataListOutputBoundary outputBoundary) {
        this.token = token;
        fetchPetProfile = new FetchPetProfile(petAPIGateway, new FetchPetProfileOutputBoundary() {
            @Override
            public void onFetchPetProfileSuccess(FetchPetProfileSuccessResponseModel response) {
                onFetchSingleProfileSuccess(response);
            }

            @Override
            public void onFetchPetProfileFailure(FetchPetProfileFailResponseModel response) {
                onFetchSingleProfileFailure(response);
            }
        });

        this.outputBoundary = outputBoundary;
    }

    /**
     * Send the next request to retrieve a singular pet profile.
     */
    private void sendNextRequest() {
        FetchPetProfileRequestModel request = new FetchPetProfileRequestModel(
                token,
                petIds.get(currentIndex)
        );

        fetchPetProfile.fetchPetProfile(request);
    }

    /**
     * Given a list of pet ids, asynchronously construct a corresponding
     * list of PetData
     *
     * @param petIds A list of pet ids
     */
    public void getPetDataList (List<String> petIds) {
        this.petIds = petIds;
        sendNextRequest();
    }

    private void onFetchSingleProfileSuccess(FetchPetProfileSuccessResponseModel response) {
        PetData newPetData = new PetData(response.getName(), response.getAge(),
                response.getBreed(), response.getBiography(), petIds.get(currentIndex));
        petDataList.add(newPetData);

        if (currentIndex < petIds.size()){
            sendNextRequest();
            currentIndex += 1;
        }else{
            this.outputBoundary.onGetPetDataListSuccess(petDataList);
        }
    }

    private void onFetchSingleProfileFailure(FetchPetProfileFailResponseModel response) {
        this.outputBoundary.onGetPetDataListFailure("Fetching a profile failed on the " +
                currentIndex + "th profile: " + response.getErrorMessage());
    }
}
