package com.example.cupetfrontend.drivers.api.mock_volley;

import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.example.cupetfrontend.drivers.api.mock_volley.MockNetwork;
import com.example.cupetfrontend.drivers.api.mock_volley.MockRequestQueue;

public class MockBackend {
    RequestQueue mockQueue;
    MockNetwork mockNetwork;

    public MockBackend() {
        mockNetwork = new MockNetwork();
        mockQueue = new MockRequestQueue(mockNetwork);
    }
}
