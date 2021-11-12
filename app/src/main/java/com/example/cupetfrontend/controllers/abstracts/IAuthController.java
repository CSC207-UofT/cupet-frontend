package com.example.cupetfrontend.controllers.abstracts;

/**
 * An interface for a controller which accesses all use cases relating
 * to user authentication.
 */
public interface IAuthController {
    /**
     * Login a user
     * @param email The user's email
     * @param password The user's password
     */
    void login(String email, String password);
}
