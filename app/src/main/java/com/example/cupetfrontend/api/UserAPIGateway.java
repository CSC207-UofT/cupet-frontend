package com.example.cupetfrontend.api;

import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;

public class UserAPIGateway implements IUserAPIGateway {
    /**
     * Create a new user.
     *
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param homeAddress The user's home address
     * @param password The user's password
     * @param email The user's email
     */
    @Override
    public String createUser(String firstName, String lastName, String homeAddress,
                             String password, String email) {
        return null;
    }
}
