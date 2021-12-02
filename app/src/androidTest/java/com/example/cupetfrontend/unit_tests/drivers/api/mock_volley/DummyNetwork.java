package com.example.cupetfrontend.unit_tests.drivers.api.mock_volley;

import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A network that produces a dummy response for all requests.
 */
public class DummyNetwork extends MockNetwork{
    private NetworkResponse dummyResponse;

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
        this.dummyResponse = createNetworkResponse(statusCode, responseBody, getDummyHeaders());
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
