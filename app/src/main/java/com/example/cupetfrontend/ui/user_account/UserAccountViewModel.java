package com.example.cupetfrontend.ui.user_account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.cupetfrontend.controllers.SessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUserAccountViewModel;

import java.util.Objects;

public class UserAccountViewModel extends ViewModel implements IUserAccountViewModel {
    private final IUserController userController;
    private final MutableLiveData<UserAccountResult> userAccountResult = new MutableLiveData<>();
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    //private String password;

    public UserAccountViewModel(IUserController userController){
        this.userController = userController;

    }

    public void getUserInformation(String token){
        userController.fetchUserAccount(token);
    }

    @Override
    public void onUserAccountSuccess(String firstName, String lastName, String address, String city){
        userAccountResult.setValue(new UserAccountResult(firstName, lastName, address, city, "tempImg"));
        //this.firstName = Objects.requireNonNull(userAccountResult.getValue()).getFirstName();
        //this.lastName = Objects.requireNonNull(userAccountResult.getValue()).getLastName();
        //this.address = Objects.requireNonNull(userAccountResult.getValue().getAddress());
        //this.city = Objects.requireNonNull(userAccountResult.getValue().getCity());
        //this.password = Objects.requireNonNull(userAccountResult.getValue().getPassword());

    }



    @Override
    public void onUserAccountFailure(String message) {
        UserAccountResult newFetchUserAccountResult = new UserAccountResult(true, message);
        userAccountResult.setValue(newFetchUserAccountResult);

    }


    public LiveData<UserAccountResult> getUserAccountResult(){
        return this.userAccountResult;
    }

}
