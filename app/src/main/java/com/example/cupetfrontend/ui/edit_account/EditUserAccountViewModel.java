package com.example.cupetfrontend.ui.edit_account;

import android.util.Patterns;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cupetfrontend.R;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserAccountViewModel;

public class EditUserAccountViewModel extends ViewModel implements IEditUserAccountViewModel {
    private final MutableLiveData<EditUserAccountResult> editUserAccountResult = new MutableLiveData<>();
    private final MutableLiveData<EditUserAccountState> editUserAccountState = new MutableLiveData<>();
    private final IUserController userController;

    public EditUserAccountViewModel (IUserController userController){
        this.userController = userController;
    }


    LiveData<EditUserAccountState> getEditUserAccountState() {
        return editUserAccountState;
    }

    LiveData<EditUserAccountResult> getEditUserAccountResult() {
        return editUserAccountResult;
    }


    public void editUserAccount(EditUserAccountData formData, String token){
        userController.editUserAccount(token, formData.getFirstname(), formData.getLastname(),
                formData.getEmail(), formData.getPassword(), formData.getAddress(), formData.getCity());
    }

    public void updateFormState(EditUserAccountData formData){
        EditUserAccountState newFormState = new EditUserAccountState();

        if (!isFirstNameValid(formData.getFirstname())) {
            newFormState.setFirstNameError(R.string.invalid_first_name);
        } else if (!isLastNameValid(formData.getLastname())) {
            newFormState.setLastNameError(R.string.invalid_last_name);
        } else if (!isEmailValid(formData.getEmail())) {
            newFormState.setEmailError(R.string.invalid_email);
        } else if (!isPasswordValid(formData.getPassword())) {
            newFormState.setPasswordError(R.string.invalid_password);
        } else if (!isHomeAddressValid(formData.getAddress())) {
            newFormState.setAddressNameError(R.string.invalid_home_address);
        } else if (!isCityValid(formData.getCity())){
            newFormState.setCityNameError(R.string.invalid_city);
        }else {
            newFormState.setDataValid(true);
        }

        editUserAccountState.setValue(newFormState);

    }

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
    public void onEditUserAccountSuccess() {
        EditUserAccountResult newEditUserAccountResult = new EditUserAccountResult(false);

        editUserAccountResult.setValue(newEditUserAccountResult);
    }

    @Override
    public void onEditUserAccountFailure(String message) {
        EditUserAccountResult newEditUserAccountResult = new EditUserAccountResult(true, message);

        editUserAccountResult.setValue(newEditUserAccountResult);
    }
}
