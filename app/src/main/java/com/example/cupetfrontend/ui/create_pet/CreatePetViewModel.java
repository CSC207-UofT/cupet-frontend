package com.example.cupetfrontend.ui.create_pet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.presenters.view_model_abstracts.ICreatePetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.CreatePetContext;

import javax.inject.Inject;

/**
 * A ViewModel class for the Create Pet page.
 * This class is responsible for storing and updating the state of the create pet form.
 */
public class CreatePetViewModel extends ViewModel implements ICreatePetViewModel {

    private final MutableLiveData<CreatePetFormState> createPetFormState = new MutableLiveData<>();
    private final MutableLiveData<CreatePetResult> createPetResult = new MutableLiveData<>();
    private final IPetController petController;
    private CreatePetContext context;

    @Inject
    public CreatePetViewModel(IPetController petController) {
        this.petController = petController;
    }

    @Override
    public LiveData<CreatePetFormState> getCreatePetFormState() {
        return createPetFormState;
    }

    @Override
    public LiveData<CreatePetResult> getCreatePetResult() {
        return createPetResult;
    }

    /**
     * Create a new create pet request
     *
     * @param token The user's session token
     * @param formData The pet creation data entered into the form
     */
    @Override
    public void createPet(String token, CreatePetFormData formData){
        petController.createPet(token, formData.getPetName(), formData.getPetAge(),
                formData.getPetBreed(), formData.getPetBio());
    }

    /**
     * Update the state of the create pet form.
     * @param formData The data entered into the form.
     */
    @Override
    public void updateFormState(CreatePetFormData formData) {
        CreatePetFormState newFormState = new CreatePetFormState();

        if (!isPetNameValid(formData.getPetName())) {
            newFormState.setPetNameError(R.string.invalid_pet_name);
        } else if (!isPetAgeValid(formData.getPetAge())) {
            newFormState.setPetAgeError(R.string.invalid_pet_age);
        } else if (!isPetBreedValid(formData.getPetBreed())) {
            newFormState.setPetBreedError(R.string.invalid_pet_breed);
        } else if (!isPetBioValid(formData.getPetBio())) {
            newFormState.setPetBioError(R.string.invalid_pet_bio);
        } else {
            newFormState.setDataValid(true);
        }

        createPetFormState.setValue(newFormState);
    }

    /**
     * Return whether petName is valid.
     * @param petName The pet's name
     * @return whether petName is valid
     */
    private boolean isPetNameValid(String petName){
        return petName != null && petName.trim().length() > 0;
    }

    /**
     * Return whether petAge is valid.
     * @param petAge The pet's age
     * @return whether petAge is valid
     */
    private boolean isPetAgeValid(String petAge){
        return petAge != null && petAge.trim().length() > 0 && isInt(petAge.trim());

    }

    /**
     * A helper method that check if petAge is an integer.
     * @param str input string (eg. petAge)
     * @return whether input string can be convert to integer.
     */
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
     * @param petBreed The pet's breed
     * @return whether petBreed is valid
     */
    private boolean isPetBreedValid(String petBreed){
        return petBreed != null && petBreed.trim().length() > 0;
    }

    /**
     * Return whether petBio is valid.
     * @param petBio The pet's breed
     * @return whether petBio is valid
     */
    private boolean isPetBioValid(String petBio){
        return petBio != null && petBio.trim().length() > 0;
    }

    @Override
    public void onCreatePetSuccess(String petId) {
        CreatePetResult newCreatePetResult = new CreatePetResult(petId);

        createPetResult.setValue(newCreatePetResult);
    }

    @Override
    public void onCreatePetFailure(String message) {
        CreatePetResult newCreatePetResult = new CreatePetResult(true, message);

        createPetResult.setValue(newCreatePetResult);
    }

    @Override
    public CreatePetContext getContext() {
        return context;
    }

    @Override
    public void setContext(CreatePetContext context) {
        this.context = context;
    }
}
