package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;


import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetProfileImageSuccessResponseModel;

import java.util.ArrayList;
import java.util.List;

public class GetMatchesPresenter implements IGetMatchesPresenter {
    IGetMatchesViewModel getMatchesViewModel;


    @Override
    public void setGetMatchesViewModel(IGetMatchesViewModel getMatchesViewModel) {
        this.getMatchesViewModel = getMatchesViewModel;
    }

    /**
     * On the successful get pet matches, handover the presented
     * data to the view model.
     *
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onGetMatchesSuccess(GetMatchesSuccessResponseModel response) {
        // create list of names of all matched pets

        ArrayList<PetModel> mPetModels = new ArrayList<>();

        for (PetData pet: response.getMatches()) {
            mPetModels.add(new PetModel(pet.getPetId(), pet.getName(), pet.getAge(),
                    pet.getBreed(), pet.getProfileImgUrl(), pet.getUserId()));

        }
        getMatchesViewModel.onGetMatchesSuccess(mPetModels);
    }

    /**
     * On the failed get pet matches, handover the presented
     * data to the view model.
     *
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onGetMatchesFailure(DefaultFailureResponseModel response) {
        getMatchesViewModel.onGetMatchesFailure(response.getErrorMessage());

    }
}
