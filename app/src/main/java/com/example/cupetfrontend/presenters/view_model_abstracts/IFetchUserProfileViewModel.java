package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface IFetchUserProfileViewModel {
    void onFetchUserProfileSuccess(String email, String phoneNumber, String facebook, String Instagram, String biography, String image);

    void onFetchUserProfileFailure(String message);
}
