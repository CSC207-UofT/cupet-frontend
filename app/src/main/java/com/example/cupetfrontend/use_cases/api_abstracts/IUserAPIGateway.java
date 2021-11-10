package com.example.cupetfrontend.use_cases.api_abstracts;

import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APICreateUserRequestModel;

/**
 * Interface with methods for interacting with an external API
 * (server) for actions relating to a User.
 */
public interface IUserAPIGateway {
    /**
     * Create a new user by calling the back-end API.
     *  @param requestData The data needed ot create a new user.
     * @param responseListener A class with callback methods for when a response is received
     */
    void createUser(APICreateUserRequestModel requestData, IServerResponseListener responseListener);
}
