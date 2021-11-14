package com.example.cupetfrontend.use_cases.api_abstracts;

import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APILoginRequestModel;

/**
 * Interface with methods for interacting with an external API
 * (server) for actions relating to authentication.
 */
public interface IAuthAPIGateway {
    /**
     * Log in a user
     *
     * @param requestData The data needed to log in the user
     * @param responseListener A class with callback methods for when a response is received
     */
    public void login(APILoginRequestModel requestData, IServerResponseListener responseListener);
}
