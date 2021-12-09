package com.example.cupetfrontend.ui.view_my_pets;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IViewMyPetsViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.ViewMyPetsContext;

import java.util.List;

import javax.inject.Inject;

public class ViewMyPetsViewModel implements IViewMyPetsViewModel {
    private final MutableLiveData<GetPetsResult> getPetsResults = new MutableLiveData<>();
    private final IUserController userController;
    private ViewMyPetsContext context;

    @Inject
    public ViewMyPetsViewModel(IUserController userController) {
        this.userController = userController;
    }

    @Override
    public LiveData<GetPetsResult> getPetsResult() {
        return getPetsResults;
    }

    /**
     * Create a new get pets request
     *
     * @param token The token
     */
    @Override
    public void getPets(String token) {
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

    @Override
    public ViewMyPetsContext getContext() {
        return context;
    }

    @Override
    public void setContext(ViewMyPetsContext context) {
        this.context = context;
    }
}
