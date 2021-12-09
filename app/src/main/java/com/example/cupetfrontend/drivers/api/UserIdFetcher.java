package com.example.cupetfrontend.drivers.api;

import com.example.cupetfrontend.controllers.InvalidJWTException;

/**
 * A helper class responsible for fetching a user id from a JWT.
 */
public class UserIdFetcher {
    public static String getUserId(String jwt) {
        return new JWTParser().getSubject(jwt);
    }
}
