package com.example.cupetfrontend.controllers.abstracts;

import com.example.cupetfrontend.controllers.InvalidJWTException;
import com.example.cupetfrontend.controllers.cached_data_models.CachedUserData;

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
     *
     * @param token The user's token
     */
    void setToken(String token);

    /**
     * Return the user id associated with the user's login token
     *
     * @return The user's id
     */
    String getUserId();

    /**
     * Return the cached data of the logged in user.
     *
     * @return The user's cached data
     */
    CachedUserData getCachedUserData();

    /**
     * Set the cached data of the logged in user
     *
     * @param cachedUserData Data to set
     */
    void setCachedUserData(CachedUserData cachedUserData);

    /**
     * Clear all the saved data relating to the user.
     * (Sign out)
     */
    void clear();
}
