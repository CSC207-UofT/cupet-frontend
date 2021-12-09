package com.example.cupetfrontend.use_cases.api_abstracts;

import org.json.JSONObject;

/**
 * Interface defining methods that allow a class to get the asynchronous
 * response of a request to the server.
 */
public interface IServerResponseListener {
    /**
     * Method that is called when a successful response is received from the server.
     *
     * @param response The server's response
     */
    void onRequestSuccess(JSONObject response);

    /**
     * Method that is called when an unsuccessful response is received from the server.
     *
     * @param response The server's response
     */
    void onRequestError(JSONObject response);
}
