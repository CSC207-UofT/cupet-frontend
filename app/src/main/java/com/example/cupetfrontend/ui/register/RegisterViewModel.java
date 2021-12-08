package com.example.cupetfrontend.ui.register;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IRegisterViewModel;
import com.example.cupetfrontend.ui.form_validators.FormFieldState;
import com.example.cupetfrontend.ui.form_validators.UserFormValidator;

/**
 * A ViewModel class for the Registration page.
 * This class is responsible for storing and updating the state of the registration form.
 */
public class RegisterViewModel extends ViewModel implements IRegisterViewModel {

    private final MutableLiveData<RegisterFormState> registerFormState = new MutableLiveData<>();
    private final MutableLiveData<RegisterResult> registerResult = new MutableLiveData<>();
    private final IUserController userController;

    public RegisterViewModel (IUserController userController) {
        this.userController = userController;
        registerFormState.setValue(new RegisterFormState());
    }

    LiveData<RegisterFormState> getRegisterFormState() {
        return registerFormState;
    }

    LiveData<RegisterResult> getRegisterResult() {
        return registerResult;
    }

    /**
     * Create a new register request
     * @param formData The registration data entered into the form
     */
    public void register(RegisterFormData formData){
        userController.createUser(formData.getFirstName(), formData.getLastName(),
                formData.getEmail(), formData.getPassword(), formData.getHomeAddress(),
                formData.getCity());
    }

    /**
     * Helper method for checking when a form's fields has
     * been interacted with.
     */
    private void checkFormStateInteracted(RegisterFormState state, RegisterFormData formData) {
        if (formData.getFirstName() != null && !formData.getFirstName().equals("")){
            state.getFirstNameState().onFieldInteracted();
        }
        if (formData.getLastName() != null && !formData.getLastName().equals("")){
            state.getLastNameState().onFieldInteracted();
        }
        if (formData.getEmail() != null && !formData.getEmail().equals("")){
            state.getEmailState().onFieldInteracted();
        }
        if (formData.getPassword() != null && !formData.getPassword().equals("")){
            state.getPasswordState().onFieldInteracted();
        }
        if (formData.getConfirmPassword() != null && !formData.getConfirmPassword().equals("")){
            state.getConfirmPasswordState().onFieldInteracted();
        }
        if (formData.getHomeAddress() != null && !formData.getHomeAddress().equals("")){
            state.getHomeAddressState().onFieldInteracted();
        }
        if (formData.getCity() != null && !formData.getCity().equals("")){
            state.getCityState().onFieldInteracted();
        }
    }

    /**
     * Update the state of the registration form.
     * @param formData The data entered into the form.
     */
    public void updateFormState(RegisterFormData formData) {
        RegisterFormState newFormState = new RegisterFormState();
        RegisterFormState oldFormState = registerFormState.getValue();

        if (oldFormState == null){
            registerFormState.setValue(newFormState);
            return;
        }

        validateForm(formData, newFormState, oldFormState);
        checkFormStateInteracted(newFormState, formData);

        registerFormState.setValue(newFormState);
    }

    private void validateForm(RegisterFormData formData, RegisterFormState newFormState, RegisterFormState oldFormState) {
        newFormState.setFirstNameState(
                new FormFieldState(
                        oldFormState.getFirstNameState(),
                        UserFormValidator.validateFirstName(formData.getFirstName())
                ));
        newFormState.setLastNameState(
                new FormFieldState(
                        oldFormState.getLastNameState(),
                        UserFormValidator.validateLastName(formData.getLastName())
                ));
        newFormState.setEmailState(
                new FormFieldState(
                        oldFormState.getEmailState(),
                        UserFormValidator.validateEmail(formData.getEmail())
                ));
        newFormState.setPasswordState(
                new FormFieldState(
                        oldFormState.getPasswordState(),
                        UserFormValidator.validatePassword(formData.getLastName())
                ));
        newFormState.setConfirmPasswordState(
                new FormFieldState(
                        oldFormState.getConfirmPasswordState(),
                        (formData.getConfirmPassword().equals(formData.getPassword())
                                ? null : "Passwords must match")
                ));
        newFormState.setHomeAddressState(
                new FormFieldState(
                        oldFormState.getHomeAddressState(),
                        UserFormValidator.validateHomeAddress(formData.getHomeAddress())
                ));
        newFormState.setCityState(
                new FormFieldState(
                        oldFormState.getCityState(),
                        UserFormValidator.validateCity(formData.getCity())
                ));
    }

    @Override
    public void onCreateUserSuccess() {
        RegisterResult newRegisterResult = new RegisterResult(false);

        registerResult.setValue(newRegisterResult);
    }

    @Override
    public void onCreateUserFailure(String message) {
        RegisterResult newRegisterResult = new RegisterResult(true, message);

        registerResult.setValue(newRegisterResult);
    }
}
