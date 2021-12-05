package com.example.cupetfrontend.ui.get_matches;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;
import com.example.cupetfrontend.ui.get_matches.GetMatchesResult;

import java.util.List;


public class GetMatchesViewModel extends ViewModel implements IGetMatchesViewModel {
    MutableLiveData<GetMatchesResult> getMatchesResults = new MutableLiveData<>();
    private final IPetController petController;



    public GetMatchesViewModel(IPetController petController) {
        this.petController = petController;
    }

    public LiveData<GetMatchesResult> getMatchesResult() {
        return getMatchesResults;
    }

    /**
     * Create a new get matches request
     * @param token The token
     * @param myPetId The ID of the pet whose matches are to be displayed
     */
    public void getMatches(String token, String myPetId){
        petController.getMatches(token, myPetId);
    }



    @Override
    public void onGetMatchesSuccess(List<PetModel> matches) {
        GetMatchesResult newGetMatchesResult = new GetMatchesResult(false, matches);
        getMatchesResults.setValue(newGetMatchesResult);
    }

    @Override
    public void onGetMatchesFailure(String message) {
        GetMatchesResult newGetMatchesResult = new GetMatchesResult(true);
        getMatchesResults.setValue(newGetMatchesResult);
    }
}