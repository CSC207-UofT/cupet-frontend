package com.example.cupetfrontend.ui.login.register2;

/**
 * An interface defining a RegisterViewModel, which should
 * have methods to update itself on response from a create user
 * request.
 */
public interface IRegisterViewModel {
    void onCreateUserSuccess();
    void onCreateUserFailure(String message);
}
