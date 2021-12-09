package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.data.model.PetModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.ViewMyPetsContext;
import com.example.cupetfrontend.ui.view_my_pets.GetPetsResult;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface IViewMyPetsViewModel {

    LiveData<GetPetsResult> getPetsResult();

    void getPets(String token);

    /**
     * This method is called when the get user's pets request was successful.
     *
     * @param pets list of user's registered pets
     */
    void onGetPetsSuccess(List<PetModel> pets);

    /**
     * This method is called when the get user's pets request failed.
     *
     * @param message The error message from the response
     */
    void onGetPetsFailure(String message);

    ViewMyPetsContext getContext();

    void setContext(ViewMyPetsContext context);
}
