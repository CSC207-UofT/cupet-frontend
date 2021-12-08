package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.abstracts.IGetPetsPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IViewMyPetsViewModel;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.GetPetsSuccessResponseModel;

import java.util.ArrayList;

public class GetPetsPresenter implements IGetPetsPresenter {
    IViewMyPetsViewModel getPetsViewModel;

    @Override
    public void setGetPetsViewModel(IViewMyPetsViewModel getPetsViewModel) {
        this.getPetsViewModel = getPetsViewModel;

    }

    /**
     * On the successful get pets, handover the presented
     * data to the view model.
     *
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onGetPetsSuccess(GetPetsSuccessResponseModel response) {
        ArrayList<PetModel> mPetModels = new ArrayList<>();

        for (PetData pet: response.getPets()) {
            mPetModels.add(new PetModel(pet.getPetId(), pet.getName(), pet.getAge(), pet.getBreed(), pet.getProfileImgUrl()));

        }
        getPetsViewModel.onGetPetsSuccess(mPetModels);

    }


    /**
     * On the failed get pets, handover the presented
     * data to the view model.
     *
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onGetPetsFailure(DefaultFailureResponseModel response) {
        getPetsViewModel.onGetPetsFailure(response.getErrorMessage());

    }
}
