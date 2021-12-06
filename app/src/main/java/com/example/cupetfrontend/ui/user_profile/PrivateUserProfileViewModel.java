package com.example.cupetfrontend.ui.user_profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.cupetfrontend.controllers.SessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.view_model_abstracts.IPrivateUserProfileViewModel;

import java.util.Objects;

public class PrivateUserProfileViewModel extends ViewModel implements IPrivateUserProfileViewModel {
    private final IUserController userController;
    private final MutableLiveData<PrivateUserProfileResult> privateUserProfileResult = new MutableLiveData<>();
    private String firstName;
    private String lastName;
    private String biography;
    private SessionManager sessionManager;


    public PrivateUserProfileViewModel(IUserController userController){
        this.userController = userController;
    }

    public void getProfileInformation(){

        userController.fetchUserProfile("testing", "1111");
    }

    @Override
    public void onPrivateProfileSuccess(String firstname, String lastname, String biography, String image_url) {
        privateUserProfileResult.setValue(new PrivateUserProfileResult(biography));
        this.biography = Objects.requireNonNull(privateUserProfileResult.getValue()).getBiography();


    }

    @Override
    public void onPrivateProfileFailure(String message) {
        PrivateUserProfileResult newPrivateUserProfileResult = new PrivateUserProfileResult(true, message);
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
