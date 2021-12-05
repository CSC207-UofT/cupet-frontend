package com.example.cupetfrontend.presenters.view_model_abstracts;

import androidx.lifecycle.ViewModel;

public interface IPrivateUserProfileViewModel {
    void onPrivateProfileSuccess(String firstname, String lastname, String biography);

    void onPrivateProfileFailure();

}
