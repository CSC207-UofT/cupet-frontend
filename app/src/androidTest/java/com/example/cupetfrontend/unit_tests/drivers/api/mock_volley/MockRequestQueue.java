package com.example.cupetfrontend.unit_tests.drivers.api.mock_volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.NoCache;

/**
 * A class that mimics the behaviour of a Volley request queue.
 *
 * This request queue has an empty cache, and uses a mock network injected
 * through the constructor.
 */
public class MockRequestQueue extends RequestQueue {
    MockNetwork mockNetwork;

    /**
     * Initialize a new instance of a MockRequestQueue
     *
     * @param mockNetwork a mock Volley network
     */
    public MockRequestQueue(MockNetwork mockNetwork) {
        super(new NoCache(), mockNetwork);
        this.mockNetwork = mockNetwork;
    }
}
