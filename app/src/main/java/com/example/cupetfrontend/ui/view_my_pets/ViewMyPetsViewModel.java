package com.example.cupetfrontend.ui.view_my_pets;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IGetPetsViewModel;

import java.util.List;

public class ViewMyPetsViewModel extends ViewModel implements IGetPetsViewModel {
    MutableLiveData<GetPetsResult> getPetsResults = new MutableLiveData<>();
    private final IUserController userController;



    public ViewMyPetsViewModel(IUserController userController) {
        this.userController = userController;
    }

    public LiveData<GetPetsResult> getPetsResult() {
        return getPetsResults;
    }

    /**
     * Create a new get pets request
     * @param token The token
     */
    public void getPets(String token){
        userController.getPets(token);
    }

    @Override
    public void onGetPetsSuccess(List<PetModel> userPets) {
        GetPetsResult newGetPetsResult = new GetPetsResult(false, userPets);
        getPetsResults.setValue(newGetPetsResult);
    }

    @Override
    public void onGetPetsFailure(String message) {
        GetPetsResult newGetPetsResult = new GetPetsResult(true);
        getPetsResults.setValue(newGetPetsResult);
    }
}
