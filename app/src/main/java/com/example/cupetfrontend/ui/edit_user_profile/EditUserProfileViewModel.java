package com.example.cupetfrontend.ui.edit_user_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditUserProfileContext;
import com.example.cupetfrontend.ui.create_pet.CreatePetFormState;
import com.example.cupetfrontend.ui.edit_pet.EditPetFormState;
import com.example.cupetfrontend.ui.form_validators.FormFieldState;
import com.example.cupetfrontend.ui.form_validators.PetFormValidator;
import com.example.cupetfrontend.ui.form_validators.UserFormValidator;
import com.example.cupetfrontend.use_cases.user.EditUserProfile;

import javax.inject.Inject;

public class EditUserProfileViewModel extends ViewModel implements IEditUserProfileViewModel {

    private final MutableLiveData<EditUserProfileResult> editUserProfileResult = new MutableLiveData<>();
    private final MutableLiveData<EditUserProfileState> editUserProfileState = new MutableLiveData<>();
    private final IUserController userController;
    private EditUserProfileContext context;

    @Inject
    public EditUserProfileViewModel(IUserController userController) {
        this.userController = userController;
    }

    @Override
    public LiveData<EditUserProfileState> getEditUserProfileState() {
        return this.editUserProfileState;
    }

    @Override
    public LiveData<EditUserProfileResult> getEditUserProfileResult() {
        return this.editUserProfileResult;
    }

    @Override
    public void setUserProfileImage(String token, String imgB64) {
        userController.setUserProfileImage(token, imgB64);
    }

    @Override
    public void editUserProfile(EditUserProfileData formData, String token) {
        userController.editUserProfile(token, formData.getBiography(),
                formData.getInstagram(), formData.getFacebook(), formData.getPhoneNumber());
    }

    @Override
    public void updateFormState(EditUserProfileData formData) {
        EditUserProfileState newFormState = new EditUserProfileState();
        EditUserProfileState oldFormState = editUserProfileState.getValue();

        if (oldFormState == null) {
            editUserProfileState.setValue(newFormState);
            return;
        }

        validateForm(formData, newFormState, oldFormState);
        checkFormStateInteracted(formData, newFormState);

        editUserProfileState.setValue(newFormState);
    }

    private void checkFormStateInteracted(EditUserProfileData formData,
                                          EditUserProfileState state) {
        if (formData.getBiography() != null && !formData.getBiography().equals("")) {
            state.getBiographyState().onFieldInteracted();
        }
        if (formData.getPhoneNumber() != null && !formData.getPhoneNumber().equals("")) {
            state.getPhoneNumberState().onFieldInteracted();
        }
        if (formData.getFacebook() != null && !formData.getFacebook().equals("")) {
            state.getFacebookState().onFieldInteracted();
        }
        if (formData.getInstagram() != null && !formData.getInstagram().equals("")) {
            state.getInstagramState().onFieldInteracted();
        }
    }

    private void validateForm(EditUserProfileData formData, EditUserProfileState newFormState,
                              EditUserProfileState oldFormState) {
        newFormState.setBiographyState(
                new FormFieldState(
                        oldFormState.getBiographyState(),
                        UserFormValidator.validateBiography(formData.getBiography())
                ));
        newFormState.setPhoneNumberState(
                new FormFieldState(
                        oldFormState.getPhoneNumberState(),
                        UserFormValidator.validatePhoneNumber(formData.getPhoneNumber())
                ));
        newFormState.setFacebookState(
                new FormFieldState(
                        oldFormState.getFacebookState(),
                        UserFormValidator.validateFacebook(formData.getFacebook())
                ));
        newFormState.setInstagramState(
                new FormFieldState(
                        oldFormState.getInstagramState(),
                        UserFormValidator.validateInstagram(formData.getInstagram())
                ));
    }


    @Override
    public void onEditUserProfileSuccess() {
        EditUserProfileResult newEditUseProfileResult = new EditUserProfileResult(false);
        editUserProfileResult.setValue(newEditUseProfileResult);
    }

    @Override
    public void onEditUserProfileFailure(String message) {
        EditUserProfileResult newEditUserProfileResult = new EditUserProfileResult(true, message);
        editUserProfileResult.setValue(newEditUserProfileResult);
    }

    @Override
    public void setContext(EditUserProfileContext context) {
        this.context = context;
    }

    @Override
    public EditUserProfileContext getContext() {
        return context;
    }

    @Override
    public void onSetUserProfileImageSuccess() {
        EditUserProfileResult newEditUserProfileResult =
                new EditUserProfileResult(false);

        editUserProfileResult.setValue(newEditUserProfileResult);
    }

    @Override
    public void onSetUserProfileImageFailure(String message) {
        EditUserProfileResult newEditUserProfileResult = new EditUserProfileResult(true, message);
        editUserProfileResult.setValue(newEditUserProfileResult);
    }

    @Override
    public void clearState() {
        editUserProfileState.setValue(null);
        editUserProfileResult.setValue(null);
    }
}
