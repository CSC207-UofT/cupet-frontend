package com.example.cupetfrontend.use_cases.api_abstracts;

import com.example.cupetfrontend.use_cases.api_abstracts.request_models.user.*;

/**
 * Interface with methods for interacting with an external API
 * (server) for actions relating to a User.
 */
public interface IUserAPIGateway {
    /**
     * Create a new user by calling the back-end API.
     * @param requestData The data needed to create a new user.
     * @param responseListener A class with callback methods for when a response is received
     */
    void createUser(APICreateUserRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Fetch a user's profile by calling the back-end API.
     *
     * @param requestData The data needed to fetch a user's profile
     * @param responseListener A class with callback methods for when a response is received
     */
    void fetchUserProfile(APIFetchUserProfileRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Edit a user's profile by calling the back-end API.
     *
     * @param requestData The data needed to edit a user's profile
     * @param responseListener A class with callback methods for when a response is received
     */
    void editUserProfile(APIEditUserProfileRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Fetch a user's account information by calling the back-end API.
     *
     * @param requestData The data needed to create a user's account
     * @param responseListener A class with callback methods for when a response is received
     */
    void fetchUserAccount(APIFetchUserAccountRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Edit a user's account by calling the back-end API.
     *
     * @param requestData The data needed to edit a user's account
     * @param responseListener A class with callback methods for when a response is received
     */
    void editUserAccount(APIEditUserAccountRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Return a user's list of pets by calling the back-end API.
     *
     * @param requestData The data needed to a user's pets
     * @param responseListener A class with callback methods for when a response is received
     */
    void getPets(APIGetPetsRequestModel requestData, IServerResponseListener responseListener);
}
