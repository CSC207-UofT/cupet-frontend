package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.presenters.abstracts.IGetPotentialMatchesPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPotentialMatchesViewModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesSuccessResponseModel;

import java.util.ArrayList;
import java.util.List;

public class GetPotentialMatchesPresenter implements IGetPotentialMatchesPresenter {
    IPotentialMatchesViewModel viewModel;

    @Override
    public void setPotentialMatchesViewModel(IPotentialMatchesViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onGetPotentialMatchesSuccess(GetPotentialMatchesSuccessResponseModel response) {
        List<PresentedPetData> presentedPetData = new ArrayList<>();

        for (PetData petData : response.getPotentialMatches()){
            presentedPetData.add(new PresentedPetData(
                    petData.getName(),
                    petData.getAge(),
                    petData.getBreed(),
                    petData.getBiography(),
                    petData.getProfileImgUrl(),
                    petData.getPetId()
            ));
        }

        viewModel.onGetPotentialMatchesSuccess(presentedPetData);
    }

    @Override
    public void onGetPotentialMatchesFailure(DefaultFailureResponseModel response) {
        viewModel.onGetPotentialMatchesFailure(response.getErrorMessage());
    }
}
