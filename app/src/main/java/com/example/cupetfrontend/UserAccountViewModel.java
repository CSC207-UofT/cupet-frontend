package com.example.cupetfrontend;

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
    private String password;
    private SessionManager sessionManager;

    public UserAccountViewModel(IUserController userController){
        this.userController = userController;

    }

    public void getUserInformation(){
        userController.fetchUserAccount("Token");
    }

    @Override
    public void onUserAccountSuccess(String firstName, String lastName, String address, String city, String password){
        userAccountResult.setValue(new UserAccountResult(firstName, lastName, address, city, password, "tempImg"));
        this.firstName = Objects.requireNonNull(userAccountResult.getValue()).getFirstName();
        this.lastName = Objects.requireNonNull(userAccountResult.getValue()).getLastName();
        this.address = Objects.requireNonNull(userAccountResult.getValue().getAddress());
        this.city = Objects.requireNonNull(userAccountResult.getValue().getCity());
        this.password = Objects.requireNonNull(userAccountResult.getValue().getPassword());

    }

    @Override
    public void onUserAccountFailure() {

    }


    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public String getPassword(){
        return this.password;
    }
    public LiveData<UserAccountResult> getUserAccountResult(){
        return this.userAccountResult;
    }
}
