package com.example.cupetfrontend.ui.register;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Patterns;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IRegisterViewModel;

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
     * Update the state of the registration form.
     * @param formData The data entered into the form.
     */
    public void updateFormState(RegisterFormData formData) {
        RegisterFormState newFormState = new RegisterFormState();

        if (!isFirstNameValid(formData.getFirstName())) {
            newFormState.setFirstnameError(R.string.invalid_first_name);
        } else if (!isLastNameValid(formData.getLastName())) {
            newFormState.setLastnameError(R.string.invalid_last_name);
        } else if (!isEmailValid(formData.getEmail())) {
            newFormState.setEmailError(R.string.invalid_email);
        } else if (!isPasswordValid(formData.getPassword())) {
            newFormState.setPasswordError(R.string.invalid_password);
        } else if (!doesConfirmPasswordMatch(formData.getPassword(), formData.getConfirmPassword())) {
            newFormState.setConfirmPasswordError(R.string.invalid_confirm_password);
        } else if (!isHomeAddressValid(formData.getHomeAddress())) {
            newFormState.setAddressError(R.string.invalid_home_address);
        } else if (!isCityValid(formData.getCity())){
            newFormState.setAddressError(R.string.invalid_city);
        }else {
            newFormState.setDataValid(true);
        }

        registerFormState.setValue(newFormState);
    }

    /**
     * Return whether firstName is valid.
     * @param firstName The user's first name
     * @return whether firstName is valid
     */
    private boolean isFirstNameValid(String firstName){
        return firstName != null && firstName.trim().length() > 2;
    }

    /**
     * Return whether lastName is valid.
     * @param lName The user's last name
     * @return whether lastName is valid
     */
    private boolean isLastNameValid(String lName){
        return lName != null && lName.trim().length() > 2;
    }

    /**
     * Return whether email is valid
     * @param email The user's email
     * @return whether email is valid
     */
    private boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        if (email.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        } else {
            return !email.trim().isEmpty();
        }
    }

    /**
     * Return whether password is valid
     * @param password The user's password
     * @return whether password is valid
     */
    private boolean isPasswordValid(String password) {
        return password != null && password.length() > 5;
    }

    /**
     * Return whether password matches confirmPassword
     * @param password The user's password
     * @param confirmPassword The confirmPassword field value
     * @return whether the two passwords match
     */
    private boolean doesConfirmPasswordMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    /**
     * Return whether homeAddress is valid
     * @param homeAddress The user's home address
     * @return whether homeAddress is valid
     */
    private boolean isHomeAddressValid(String homeAddress) {
        return homeAddress != null && homeAddress.trim().length() > 5;
    }

    /**
     * Return whether city is valid
     * @param city The user's city
     * @return whether city is valid
     */
    private boolean isCityValid(String city) {
        return city != null && city.trim().length() > 2;
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
