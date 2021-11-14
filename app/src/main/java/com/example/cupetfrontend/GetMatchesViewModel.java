package com.example.cupetfrontend;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.abstracts.IGetMatchesPresenter;
import com.example.cupetfrontend.presenters.pet.GetMatchesPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IGetMatchesViewModel;

import java.util.List;


public class GetMatchesViewModel extends ViewModel implements IGetMatchesViewModel {
    private final MutableLiveData<IGetMatchesPresenter> getMatchesPresenterData = new MutableLiveData<>();
    private IPetController petController;


    public GetMatchesViewModel(IPetController petController) {
        this.petController = petController;
    }

    LiveData<IGetMatchesPresenter> getMatchesResult() {
        return getMatchesPresenterData;
    }


    public void getMatches(String token, String myPetId){
        petController.getMatches(token, myPetId);
    }


    @Override
    public void onGetMatchesSuccess(List<String> matches) {

    }

    @Override
    public void onGetMatchesFailure(String message) {

    }
}