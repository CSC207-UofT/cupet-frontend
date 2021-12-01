package com.example.cupetfrontend;

import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.ICreaterPetViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IRegisterViewModel;
import com.example.cupetfrontend.ui.register.RegisterFormData;
import com.example.cupetfrontend.ui.register.RegisterFormState;
import com.example.cupetfrontend.ui.register.RegisterResult;

public class CreatePetViewModel extends ViewModel implements ICreaterPetViewModel {

    private final MutableLiveData<CreatePetState> createPetState= new MutableLiveData<>();
    private final MutableLiveData<CreatePetResult> createPetResult = new MutableLiveData<>();
    private final IPetController petController;

    public CreatePetViewModel (IPetController petController) {

        this.petController = petController;
    }

    LiveData<CreatePetState> getCreatePetState() {
        return createPetState;
    }

    LiveData<CreatePetResult> getCreatePetResult() {
        return createPetResult;
    }

    /**
     * Create a new pet creation request
     * @param formData The pet data entered into the form
     *                 NEED TOKEN FOR PET
     */
    public void createPetProfile(CreatePetProfileData formData){
        petController.createPet("123", formData.getName(), String.valueOf(formData.getAge()), formData.getBiography(), formData.getBreed());
    }

    /**
     * Update the state of the registration form.
     * @param formData The data entered into the form.
     */
    public void updateFormState(CreatePetProfileData formData) {
        CreatePetState newFormState = new CreatePetState();

        if (!isNameValid(formData.getName())) {
            newFormState.setNameError(R.string.invalid_name);
        } else if (!isAgeValid(String.valueOf(formData.getAge()))) {
            newFormState.setAgeError(R.string.invalid_age);
        } else if (!isBiographyValid(formData.getBiography())) {
            newFormState.setBiographyError(R.string.invalid_biography);
        } else if (!isBreedValid(formData.getBreed())) {
            newFormState.setBreedError(R.string.invalid_breed);
        }else {
            newFormState.setDataValid(true);
        }

        createPetState.setValue(newFormState);
    }

    /**
     * Return whether name is valid.
     * @param name The pet's name
     * @return whether name is valid
     */
    private boolean isNameValid(String name){
        return name != null && name.trim().length() > 1;
    }

    /**
     * Return whether age is valid.
     * @param age The pet's age.
     * @return whether age is valid
     */
    private boolean isAgeValid(String age){
        return age != null && age.trim().length() < 3;
    }

    /**
     * Return whether biography is valid
     * @param biography The pet's biography
     * @return whether email is valid
     */
    private boolean isBiographyValid(String biography) {
        return biography != null;
    }

    /**
     * Return whether breed is valid
     * @param breed The user's password
     * @return whether breed is valid
     */
    private boolean isBreedValid(String breed) {
        return breed != null;
    }




    @Override
    public void onCreatePetSuccess() {

    }

    @Override
    public void onCreatePetFailure(String message) {

    }
}
