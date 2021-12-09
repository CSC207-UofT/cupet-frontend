package com.example.cupetfrontend.use_cases.api_abstracts;

import org.json.JSONObject;

import java.util.Map;

/**
 * An interface describing a class responsible for sending
 * requests to the back-end server.
 */
public interface IServerRequestManager {

    /**
     * Make an HTTP GET request with a JSON body that expects a JSON
     * response.
     *
     * @param url      The url of the HTTP request
     * @param queryMap The query parameters for the request
     * @param headers  The headers from the HTTP request
     * @param listener An object that listens to the server response
     */
    void makeGetRequest(String url, Map<String, String> queryMap,
                        Map<String, String> headers, IServerResponseListener listener);

    /**
     * Make an HTTP GET request with a JSON body that expects a JSON
     * response.
     *
     * @param url      The url of the HTTP request
     * @param queryMap The query parameters for the request
     * @param listener An object that listens to the server response
     */
    void makeGetRequest(String url, Map<String, String> queryMap, IServerResponseListener listener);

    /**
     * Make an HTTP POST request with a JSON body that expects a JSON
     * response.
     *
     * @param url         The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param listener    An object that listens to the server response
     */
    void makePostRequest(String url, JSONObject requestBody, IServerResponseListener listener);

    /**
     * Make an HTTP POST request with a JSON body that expects a JSON
     * response.
     *
     * @param url         The url of the HTTP request
     * @param requestBody The body of the HTTP request as a JSONObject
     * @param headers     The headers from the HTTP request
     * @param listener    An object that listens to the server response
     */
    void makePostRequest(String url, JSONObject requestBody,
                         Map<String, String> headers, IServerResponseListener listener);
}
