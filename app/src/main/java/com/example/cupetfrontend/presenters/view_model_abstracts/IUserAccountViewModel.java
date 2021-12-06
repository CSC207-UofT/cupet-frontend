package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface IUserAccountViewModel {
    void onUserAccountSuccess(String firstname, String lastname, String address, String city, String password);

    void onUserAccountFailure();
}
