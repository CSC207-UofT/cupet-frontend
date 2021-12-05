package com.example.cupetfrontend.presenters.view_model_abstracts;

public interface ILoginViewModel {
    /**
     * This method is called when the login request was successful.
     *
     * @param token The session token from the response
     */
    void onLoginSuccess(String token);

    /**
     * This method is called when the login user request failed.
     *
     * @param message The error message from the response
     */
    void onLoginFailure(String message);
}
