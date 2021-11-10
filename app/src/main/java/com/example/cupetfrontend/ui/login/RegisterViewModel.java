package com.example.cupetfrontend.ui.login;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Patterns;

import com.example.cupetfrontend.data.LoginRepository;
import com.example.cupetfrontend.data.Result;
import com.example.cupetfrontend.data.model.LoggedInUser;
import com.example.cupetfrontend.R;

public class RegisterViewModel extends ViewModel implements IRegisterViewModel{

    private MutableLiveData<RegisterFormState> registerFormState = new MutableLiveData<>();
    private MutableLiveData<RegisterResult> registerResult = new MutableLiveData<>();
    private LoginRepository loginRepository; // do I need register repository

    public void register(String fName, String lName, String email, String password, String address){}
    //

    public void registerDataChanged(String fName, String lName, String email, String password) {
        if (!isFNameValid(fName)){
            registerFormState.setValue(new RegisterFormState(null, null, null, null, null));
        } //change to add fName error
        // add lName valid
        if (!isEmailValid(email)) {
            registerFormState.setValue(new RegisterFormState(null, null, R.string.invalid_username, null, null));
        } else if (!isPasswordValid(password)) {
            registerFormState.setValue(new RegisterFormState(null, null, null, R.string.invalid_password, null));
        } // confirm password
        // add address valid
        else {
            registerFormState.setValue(new RegisterFormState(true));
        }


    }

    // A placeholder first name validation check
    private boolean isFNameValid(String fName){
        return fName != null && fName.trim().length() > 2;
    }

    // A placeholder last name validation check
    private boolean isLNameValid(String lName){
        return lName != null && lName.trim().length() > 2;
    }

    // A placeholder email validation check
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

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }


    // A placeholder address validation check
    private boolean isAddressValid(String address) {
        return address != null && address.trim().length() > 5;
    }

    @Override
    public void onCreateUserSuccess() {
        // TODO: Update the user interface showing that the user has successfully been created.
        System.out.println("User successfully created!");
    }

    @Override
    public void onCreateUserFailure(String message) {
        // TODO: Update the user interface showing that the user has failed to been created and display message.
        System.out.println("User failed to be created: " + message);
    }
}
