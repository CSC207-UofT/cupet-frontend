package com.example.cupetfrontend.ui.edit_account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserAccountViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models.EditUserAccountContext;
import com.example.cupetfrontend.ui.edit_pet.EditPetFormData;
import com.example.cupetfrontend.ui.edit_pet.EditPetFormState;
import com.example.cupetfrontend.ui.form_validators.FormFieldState;
import com.example.cupetfrontend.ui.form_validators.PetFormValidator;
import com.example.cupetfrontend.ui.form_validators.UserFormValidator;

import javax.inject.Inject;

public class EditUserAccountViewModel extends ViewModel implements IEditUserAccountViewModel {
    private final MutableLiveData<EditUserAccountResult> editUserAccountResult = new MutableLiveData<>();
    private final MutableLiveData<EditUserAccountFormState> formState = new MutableLiveData<>();
    private final IUserController userController;
    private EditUserAccountContext context;

    @Inject
    public EditUserAccountViewModel(IUserController userController) {
        this.userController = userController;
    }

    @Override
    public LiveData<EditUserAccountFormState> getFormState() {
        return formState;
    }

    @Override
    public LiveData<EditUserAccountResult> getEditUserAccountResult() {
        return editUserAccountResult;
    }

    @Override
    public void editUserAccount(EditUserAccountFormData formData, String token) {
        if (formData.getPassword() == null || formData.getPassword().equals("")) {
            userController.editUserAccount(token, formData.getFirstname(), formData.getLastname(),
                    formData.getEmail(), formData.getAddress(), formData.getCity());
        } else {
            userController.editUserAccount(token, formData.getFirstname(), formData.getLastname(),
                    formData.getEmail(), formData.getPassword(), formData.getAddress(), formData.getCity());
        }
    }

    @Override
    public void updateFormState(EditUserAccountFormData formData) {
        EditUserAccountFormState newFormState = new EditUserAccountFormState();
        EditUserAccountFormState oldFormState = formState.getValue();

        if (oldFormState == null) {
            formState.setValue(newFormState);
            return;
        }

        validateForm(formData, newFormState, oldFormState);
        checkFormStateInteracted(formData, newFormState);

        formState.setValue(newFormState);
    }

    private void validateForm(EditUserAccountFormData formData, EditUserAccountFormState newFormState,
                              EditUserAccountFormState oldFormState) {
        newFormState.setFirstNameState(
                new FormFieldState(
                        oldFormState.getFirstNameState(),
                        UserFormValidator.validateFirstName(formData.getFirstname())
                ));
        newFormState.setLastNameState(
                new FormFieldState(
                        oldFormState.getLastNameState(),
                        UserFormValidator.validateLastName(formData.getLastname())
                ));
        newFormState.setEmailState(
                new FormFieldState(
                        oldFormState.getEmailState(),
                        UserFormValidator.validateEmail(formData.getEmail())
                ));

        String password = formData.getPassword();

        newFormState.setPasswordState(
                new FormFieldState(
                        oldFormState.getPasswordState(),
                        password.equals("") ? null : UserFormValidator.validatePassword(formData.getPassword())
                ));
        newFormState.setConfirmPasswordState(
                new FormFieldState(
                        oldFormState.getConfirmPasswordState(),
                        formData.getPassword().equals(formData.getConfirmPassword()) ? null :
                                "Passwords must match"
                ));
        newFormState.setHomeAddressState(
                new FormFieldState(
                        oldFormState.getHomeAddressState(),
                        UserFormValidator.validateHomeAddress(formData.getAddress())
                ));
        newFormState.setCityState(
                new FormFieldState(
                        oldFormState.getCityState(),
                        UserFormValidator.validateCity(formData.getCity())
                ));
    }

    private void checkFormStateInteracted(EditUserAccountFormData formData,
                                          EditUserAccountFormState state) {
        if (formData.getFirstname() != null && !formData.getFirstname().equals("")) {
            state.getFirstNameState().onFieldInteracted();
        }
        if (formData.getLastname() != null && !formData.getLastname().equals("")) {
            state.getLastNameState().onFieldInteracted();
        }
        if (formData.getEmail() != null && !formData.getEmail().equals("")) {
            state.getEmailState().onFieldInteracted();
        }
        if (formData.getPassword() != null && !formData.getPassword().equals("")) {
            state.getPasswordState().onFieldInteracted();
        }
        if (formData.getConfirmPassword() != null && !formData.getConfirmPassword().equals("")) {
            state.getConfirmPasswordState().onFieldInteracted();
        }
        if (formData.getAddress() != null && !formData.getAddress().equals("")) {
            state.getHomeAddressState().onFieldInteracted();
        }
        if (formData.getCity() != null && !formData.getCity().equals("")) {
            state.getCityState().onFieldInteracted();
        }
    }


    @Override
    public void onEditUserAccountSuccess() {
        EditUserAccountResult newEditUserAccountResult = new EditUserAccountResult(false);

        editUserAccountResult.setValue(newEditUserAccountResult);
    }

    @Override
    public void onEditUserAccountFailure(String message) {
        EditUserAccountResult newEditUserAccountResult = new EditUserAccountResult(true, message);

        editUserAccountResult.setValue(newEditUserAccountResult);
    }

    @Override
    public EditUserAccountContext getContext() {
        return context;
    }

    @Override
    public void setContext(EditUserAccountContext context) {
        this.context = context;
    }
}
