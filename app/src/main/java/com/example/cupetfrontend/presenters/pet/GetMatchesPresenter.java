package com.example.cupetfrontend.presenters.pet;

import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;
import com.example.cupetfrontend.use_cases.response_models.PetData;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;

import java.util.ArrayList;

public class GetMatchesPresenter implements IGetMatchesPresenter {
    IGetMatchesViewModel getMatchesViewModel;

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

        // TODO: Determine and provide all appropriate information for getMatchesViewModel

        ArrayList<String> matches = new ArrayList<>();
        for (PetData petData: response.getMatches()) {
            matches.add(petData.getName());
        }
        getMatchesViewModel.onGetMatchesSuccess(matches);

    }

    /**
     * On the failed get pet matches, handover the presented
     * data to the view model.
     *
     *
     * @param response The response from the use case's layer
     */
    @Override
    public void onGetMatchesFailure(GetMatchesFailResponseModel response) {
        getMatchesViewModel.onGetMatchesFailure(response.getErrorMessage());

    }
}
