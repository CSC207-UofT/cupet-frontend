package com.example.cupetfrontend;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;
import com.example.cupetfrontend.presenters.pet.GetMatchesPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;
import com.example.cupetfrontend.ui.register.RegisterResult;

import java.util.List;


public class GetMatchesViewModel extends ViewModel implements IGetMatchesViewModel {
    private final MutableLiveData<GetMatchesResult> getMatchesResult = new MutableLiveData<>();
    private IPetController petController;


    public GetMatchesViewModel(IPetController petController) {
        this.petController = petController;
    }

    LiveData<GetMatchesResult> getMatchesResult() {
        return getMatchesResult;
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
    public void onGetMatchesSuccess(List<String> matches) {
        GetMatchesResult newGetMatchesResult = new GetMatchesResult(false, matches);
        getMatchesResult.setValue(newGetMatchesResult);
    }

    @Override
    public void onGetMatchesFailure(String message) {
        GetMatchesResult newGetMatchesResult = new GetMatchesResult(true);
        getMatchesResult.setValue(newGetMatchesResult);

    }
}