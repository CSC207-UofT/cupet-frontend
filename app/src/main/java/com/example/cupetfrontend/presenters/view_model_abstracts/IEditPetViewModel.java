package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditPetContext;
import com.example.cupetfrontend.ui.edit_pet.EditPetFormData;
import com.example.cupetfrontend.ui.edit_pet.EditPetFormState;
import com.example.cupetfrontend.ui.edit_pet.EditPetResult;

import androidx.lifecycle.LiveData;

public interface IEditPetViewModel {
    LiveData<EditPetFormState> getEditPetFormState();

    LiveData<EditPetResult> getEditPetResult();

    void editPet(EditPetFormData formData);

    void setPetProfileImage(String b64);

    void updateFormState(EditPetFormData formData);

    /**
     * This method is called when the edit pet request was successful.
     */
    void onEditPetSuccess();

    /**
     * This method is called when the edit pet request failed.
     *
     * @param message The error message from the response
     */
    void onEditPetFailure(String message);

    EditPetContext getContext();

    void setContext(EditPetContext context);
}
