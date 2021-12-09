package com.example.cupetfrontend.ui.edit_pet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditPetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditPetContext;
import com.example.cupetfrontend.ui.form_validators.FormFieldState;
import com.example.cupetfrontend.ui.form_validators.PetFormValidator;
import com.example.cupetfrontend.ui.form_validators.UserFormValidator;

import javax.inject.Inject;

/**
 * A ViewModel class for the Edit Pet page.
 * This class is responsible for storing and updating the state of the edit pet form.
 */
public class EditPetViewModel extends ViewModel implements IEditPetViewModel {
    private final MutableLiveData<EditPetFormState> editPetFormState = new MutableLiveData<>();
    private final MutableLiveData<EditPetResult> editPetResult = new MutableLiveData<>();

    private final IPetController petController;
    public ISessionManager sessionManager;
    public IPetSessionManager petSessionManager;

    private EditPetContext context;

    @Inject
    public EditPetViewModel(IPetController petController, ISessionManager sessionManager,
                            IPetSessionManager petSessionManager) {
        this.petController = petController;
        this.sessionManager = sessionManager;
        this.petSessionManager = petSessionManager;
    }

    @Override
    public LiveData<EditPetFormState> getEditPetFormState() {
        return editPetFormState;
    }

    @Override
    public LiveData<EditPetResult> getEditPetResult() {
        return editPetResult;
    }

    @Override
    public void editPet(EditPetFormData formData) {
        petController.editPet(sessionManager.getToken(), petSessionManager.getPetId(), formData.getPetName(), formData.getPetAge(),
                formData.getPetBreed(), formData.getPetBio());
    }

    @Override
    public void setPetProfileImage(String b64) {
        petController.setPetProfileImage(sessionManager.getToken(), petSessionManager.getPetId(), b64);
    }

    /**
     * Update the state of the edit pet form.
     *
     * @param formData The data entered into the form.
     */
    @Override
    public void updateFormState(EditPetFormData formData) {
        EditPetFormState newFormState = new EditPetFormState();
        EditPetFormState oldFormState = editPetFormState.getValue();

        if (oldFormState == null) {
            editPetFormState.setValue(newFormState);
            return;
        }

        validateForm(formData, newFormState, oldFormState);
        checkFormStateInteracted(formData, newFormState);

        editPetFormState.setValue(newFormState);
    }

    private void validateForm(EditPetFormData formData, EditPetFormState newFormState,
                              EditPetFormState oldFormState) {
        newFormState.setNameState(
                new FormFieldState(
                        oldFormState.getNameState(),
                        PetFormValidator.validatePetName(formData.getPetName())
                ));
        newFormState.setAgeState(
                new FormFieldState(
                        oldFormState.getAgeState(),
                        PetFormValidator.validateAge(formData.getPetAge())
                ));
        newFormState.setBreedState(
                new FormFieldState(
                        oldFormState.getBreedState(),
                        PetFormValidator.validateBreed(formData.getPetBreed())
                ));
        newFormState.setBiographyState(
                new FormFieldState(
                        oldFormState.getBiographyState(),
                        PetFormValidator.validateBiography(formData.getPetBio())
                ));
    }

    private void checkFormStateInteracted(EditPetFormData formData, EditPetFormState state) {
        if (formData.getPetName() != null && !formData.getPetName().equals("")) {
            state.getNameState().onFieldInteracted();
        }
        if (formData.getPetAge() != null && !formData.getPetAge().equals("")) {
            state.getAgeState().onFieldInteracted();
        }
        if (formData.getPetBreed() != null && !formData.getPetBreed().equals("")) {
            state.getBreedState().onFieldInteracted();
        }
        if (formData.getPetBio() != null && !formData.getPetBio().equals("")) {
            state.getBiographyState().onFieldInteracted();
        }
    }

    /**
     * Return whether petName is valid.
     *
     * @param petName The pet's name
     * @return whether petName is valid
     */
    private boolean isPetNameValid(String petName) {
        return petName != null && petName.trim().length() > 0;
    }

    /**
     * Return whether petAge is valid.
     *
     * @param petAge The pet's age
     * @return whether petAge is valid
     */
    private boolean isPetAgeValid(String petAge) {
        return petAge != null && petAge.trim().length() > 0 && isInt(petAge.trim());

    }

    // Helper method
    public static boolean isInt(String str) {
        try {
            @SuppressWarnings("unused")
            int x = Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Return whether petBreed is valid.
     *
     * @param petBreed The pet's breed
     * @return whether petBreed is valid
     */
    private boolean isPetBreedValid(String petBreed) {
        return petBreed != null && petBreed.trim().length() > 0;
    }

    /**
     * Return whether petBio is valid.
     *
     * @param petBio The pet's breed
     * @return whether petBio is valid
     */
    private boolean isPetBioValid(String petBio) {
        return petBio != null && petBio.trim().length() > 0;
    }

    @Override
    public void onEditPetSuccess() {
        EditPetResult newEditPetResult = new EditPetResult(false);

        editPetResult.setValue(newEditPetResult);
    }

    @Override
    public void onEditPetFailure(String message) {
        EditPetResult newEditPetResult = new EditPetResult(true, message);

        editPetResult.setValue(newEditPetResult);
    }

    @Override
    public EditPetContext getContext() {
        return context;
    }

    @Override
    public void setContext(EditPetContext context) {
        this.context = context;
    }

    @Override
    public void clearState() {
        editPetFormState.setValue(null);
        editPetResult.setValue(null);
    }
}
