package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.CreatePetContext;
import com.example.cupetfrontend.ui.create_pet.CreatePetFormData;
import com.example.cupetfrontend.ui.create_pet.CreatePetFormState;
import com.example.cupetfrontend.ui.create_pet.CreatePetResult;

import androidx.lifecycle.LiveData;

public interface ICreatePetViewModel {
    LiveData<CreatePetFormState> getCreatePetFormState();

    LiveData<CreatePetResult> getCreatePetResult();

    void createPet(String token, CreatePetFormData formData);

    void updateFormState(CreatePetFormData formData);

    /**
     * This method is called when the create pet request was successful.
     */
    void onCreatePetSuccess(String petId);

    /**
     * This method is called when the create pet request failed.
     *
     * @param message The error message from the response
     */
    void onCreatePetFailure(String message);

    CreatePetContext getContext();

    void setContext(CreatePetContext context);

    void clearState();
}
