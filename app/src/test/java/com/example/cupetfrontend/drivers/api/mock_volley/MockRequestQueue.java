package com.example.cupetfrontend.drivers.api.mock_volley;

import com.android.volley.*;
import com.android.volley.toolbox.NoCache;

public class MockRequestQueue extends RequestQueue {
    MockNetwork mockNetwork;
    public MockRequestQueue(MockNetwork mockNetwork) {
        super(new NoCache(), mockNetwork);
        this.mockNetwork = mockNetwork;
    }
}
