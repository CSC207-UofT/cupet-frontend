package com.example.cupetfrontend.drivers.api.mock_volley;

import com.android.volley.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that mimics the behaviour of a Volley network.
 */
abstract public class MockNetwork implements Network {

    /**
     * Convert a JSONObject to a byte array
     *
     * @param data The data to convert
     * @return The data as a byte array
     */
    protected byte[] toByteArray(JSONObject data) {
        return data.toString().getBytes();
    }

    /**
     * Create a network response using a JSONObject response body.
     * The network response is initialized with dummy values relating to
     * how long the request took in the network (as the network is a mock).
     *
     * @param statusCode The HTTP status code (ex. 400, 202, etc.)
     * @param responseBody The response body
     * @param headers The response headers
     *
     * @return A new network response based on this data
     */
    protected NetworkResponse createNetworkResponse(int statusCode, JSONObject responseBody, List<Header> headers){
        return new NetworkResponse(statusCode, toByteArray(responseBody), true, 1000, headers);
    }
}
