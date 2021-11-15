package com.example.cupetfrontend.controllers.abstracts;

import com.example.cupetfrontend.controllers.InvalidJWTException;

/**
 * An interface describing a class responsible for storing the user's session token
 */
public interface ISessionManager {
    /**
     * Return the current user's login token
     *
     * @return The user's token
     */
    String getToken();

    /**
     * Set the current user's login token
     * @param token The user's token
     */
    void setToken(String token) throws InvalidJWTException;

    /**
     * Return the user id associated with the user's login token
     *
     * @return The user's id
     */
    String getUserId();
}
