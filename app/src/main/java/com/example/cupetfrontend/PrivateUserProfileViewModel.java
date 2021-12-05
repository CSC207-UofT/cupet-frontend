package com.example.cupetfrontend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.user.FetchUserProfilePresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPrivateUserProfileViewModel;

import java.util.Objects;

public class PrivateUserProfileViewModel extends ViewModel implements IPrivateUserProfileViewModel {
    private final IUserController userController;
    private final MutableLiveData<PrivateUserProfileResult> privateUserProfileResult = new MutableLiveData<>();
    private String firstName;
    private String lastName;
    private String biography;

    public PrivateUserProfileViewModel(IUserController userController){
        this.userController = userController;
    }

    public void getProfileInformation(){
        userController.fetchUserProfile("testing", "1111");
    }

    @Override
    public void onPrivateProfileSuccess(String firstname, String lastname, String biography) {
        privateUserProfileResult.setValue(new PrivateUserProfileResult(firstname, lastname, biography));
        this.firstName = Objects.requireNonNull(privateUserProfileResult.getValue()).getFirstName();
        this.lastName = Objects.requireNonNull(privateUserProfileResult.getValue()).getLastName();
        this.biography = Objects.requireNonNull(privateUserProfileResult.getValue()).getBiography();


    }

    @Override
    public void onPrivateProfileFailure() {

    }
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getBiography(){
        return this.biography;
    }

    public LiveData<PrivateUserProfileResult> getPrivateUserProfileResult(){
        return this.privateUserProfileResult;
    }

}
