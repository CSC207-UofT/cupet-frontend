package com.example.cupetfrontend.drivers.api.mock_volley;

import com.android.volley.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class that mimics the behaviour of a network.
 *
 * When a request is made to this network, a dummy response is given through
 * the setDummyResponse and getDummyResponse methods.
 */
public class MockNetwork implements Network {
    NetworkResponse dummyResponse;

    /**
     * Convert a JSONObject to a byte array
     *
     * @param data The data to convert
     * @return The data as a byte array
     */
    public byte[] toByteArray(JSONObject data) {
        return data.toString().getBytes();
    }

    /**
     * Return a list of dummy headers.
     *
     * @return a list of dummy headers
     */
    public List<Header> getDummyHeaders() {
        List<Header> headers = new ArrayList<>();

        headers.add(new Header("header1", "val1"));
        headers.add(new Header("header2", "val2"));

        return headers;
    }

    /**
     * Return a dummy server response that will be given for all future
     * server responses until a new dummy response is set.
     *
     * @param statusCode The status code for the response
     * @param responseBody The response body
     */
    public void setDummyResponse(int statusCode, JSONObject responseBody) {
        this.dummyResponse = new NetworkResponse(statusCode, toByteArray(responseBody),
                true, 1000, getDummyHeaders());
    }

    /**
     * Perform a request to the mock network. The mock network simply
     * returns a dummy response to any request.
     *
     * @param request The request made to the network
     * @return The network's dummy response
     */
    @Override
    public NetworkResponse performRequest(Request<?> request) {
        return dummyResponse;
    }
}
