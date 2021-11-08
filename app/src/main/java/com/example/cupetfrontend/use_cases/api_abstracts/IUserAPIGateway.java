package com.example.cupetfrontend.use_cases.api_abstracts;

/**
 * Interface with methods for interacting with an external API
 * (server) for actions relating to a User.
 */
public interface IUserAPIGateway {
    /**
     * Create a new user.
     *
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param homeAddress The user's home address
     * @param password The user's password
     * @param email The user's email
     */
    String createUser(String firstName, String lastName, String homeAddress, String password, String email);
}
