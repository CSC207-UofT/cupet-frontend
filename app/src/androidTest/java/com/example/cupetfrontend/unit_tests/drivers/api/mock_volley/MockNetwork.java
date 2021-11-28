package com.example.cupetfrontend.unit_tests.drivers.api.mock_volley;

import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import org.json.JSONObject;

import java.util.List;

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
