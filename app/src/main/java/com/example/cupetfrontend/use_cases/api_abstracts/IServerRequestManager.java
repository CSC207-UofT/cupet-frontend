package com.example.cupetfrontend.use_cases.api_abstracts;

import org.json.JSONObject;

/**
 * An interface describing a class responsible for sending
 * requests to the back-end server.
 */
public interface IServerRequestManager {
    /**
     * Make an HTTP POST request with a JSON body that expects a JSON
     * response.
     *
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param listener An object that listens to the server response
     */
    void makePostRequest(String url, JSONObject requestBody, IServerResponseListener listener);

    /**
     * Make an HTTP GET request with a JSON body that expects a JSON
     * response.
     *
     * @param url The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param listener An object that listens to the server response
     */
    void makeGetRequest(String url, JSONObject requestBody, IServerResponseListener listener);
}
