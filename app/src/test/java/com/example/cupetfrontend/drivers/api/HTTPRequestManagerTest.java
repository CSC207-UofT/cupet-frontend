package com.example.cupetfrontend.drivers.api;

import com.example.cupetfrontend.drivers.api.mock_volley.DummyNetwork;
import com.example.cupetfrontend.drivers.api.mock_volley.MockNetwork;
import com.example.cupetfrontend.drivers.api.mock_volley.MockRequestQueue;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HTTPRequestManagerTest extends AsyncTestClass{
    private HTTPRequestManager requestManager;
    private DummyNetwork dummyNetwork;

    @Before
    public void setUp(){
        dummyNetwork = new DummyNetwork();
        requestManager = new HTTPRequestManager(new MockRequestQueue(dummyNetwork));
    }

    /**
     * Create a dummy request body, containing dummy params
     * and data values.
     *
     * @return a dummy request body
     */
    public JSONObject makeDummyRequestBody () {
        Map<String, String> dummyDataMap = new HashMap<>();
        dummyDataMap.put("testParam1", "abc");
        dummyDataMap.put("testParam2", "1234");
        dummyDataMap.put("testParam3", "xef");

        JSONObject requestBody = new JSONObject(dummyDataMap);

        return requestBody;
    }

    /**
     * Create a dummy response body, containing dummy params
     * and data values.
     *
     * @return a dummy response body
     */
    public JSONObject makeDummyResponseBody() {
        Map<String, String> dummyDataMap = new HashMap<>();
        dummyDataMap.put("resp1", "abc");
        dummyDataMap.put("resp2", "1234");
        dummyDataMap.put("resp3", "xef");

        return new JSONObject(dummyDataMap);
    }

    /**
     * Test that the correct listener method is called on a successful GET request
     * and that the correct response is given by the server.
     */
    @Test
    public void testGETSuccess() {
        JSONObject requestBody = makeDummyRequestBody();
        JSONObject responseBody = makeDummyResponseBody();

        IServerResponseListener listener = new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject response) {
                setTaskComplete();

                assertEquals(response, responseBody);
            }

            @Override
            public void onRequestError(JSONObject response) {
                fail("Incorrectly called error listener");
            }
        };

        dummyNetwork.setDummyResponse(200, responseBody);
        requestManager.makeGetRequest("dummy_url", requestBody, listener);
        awaitForTask(500);
    }

    /**
     * Test that the correct listener method is called on an unsuccessful GET request
     * and that the correct response is given by the server.
     */
    @Test
    public void testGETFailure() {
        JSONObject requestBody = makeDummyRequestBody();
        JSONObject responseBody = makeDummyResponseBody();

        IServerResponseListener listener = new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject response) {
                fail("Incorrectly called success listener");
            }

            @Override
            public void onRequestError(JSONObject response) {
                setTaskComplete();

                assertEquals(response, responseBody);
            }
        };

        dummyNetwork.setDummyResponse(400, responseBody);
        requestManager.makeGetRequest("dummy_url", requestBody, listener);
        awaitForTask(500);
    }


    /**
     * Test that the correct listener method is called on a successful POST request
     * and that the correct response is given by the server.
     */
    @Test
    public void testPOSTSuccess() {
        JSONObject requestBody = makeDummyRequestBody();
        JSONObject responseBody = makeDummyResponseBody();

        IServerResponseListener listener = new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject response) {
                setTaskComplete();

                assertEquals(response, responseBody);
            }

            @Override
            public void onRequestError(JSONObject response) {
                fail("Incorrectly called error listener");
            }
        };

        dummyNetwork.setDummyResponse(200, responseBody);
        requestManager.makePostRequest("dummy_url", requestBody, listener);
        awaitForTask(500);
    }

    /**
     * Test that the correct listener method is called on an unsuccessful POST request
     * and that the correct response is given by the server.
     */
    @Test
    public void testPOSTFailure() {
        JSONObject requestBody = makeDummyRequestBody();
        JSONObject responseBody = makeDummyResponseBody();

        IServerResponseListener listener = new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject response) {
                fail("Incorrectly called success listener");
            }

            @Override
            public void onRequestError(JSONObject response) {
                setTaskComplete();

                assertEquals(response, responseBody);
            }
        };

        dummyNetwork.setDummyResponse(400, responseBody);
        requestManager.makePostRequest("dummy_url", requestBody, listener);
        awaitForTask(500);
    }
}
