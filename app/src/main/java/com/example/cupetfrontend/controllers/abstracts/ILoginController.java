package com.example.cupetfrontend.controllers.abstracts;

public interface ILoginController {
    /**
     * Login a user
     * @param email The user's email
     * @param password The user's password
     */
    void login(String email, String password);
}
