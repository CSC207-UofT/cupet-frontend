package com.example.cupetfrontend.controllers.abstracts;

public interface IUserController {
    /**
     * Create a new user.
     *
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param email The email of the user
     * @param password The password of the user
     * @param homeAddress The home address of the user
     */
    void createUser(String firstName, String lastName, String email, String password, String homeAddress);
}
