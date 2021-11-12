package com.example.cupetfrontend.drivers.api;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import com.example.cupetfrontend.AsyncTestClass;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.APICreateUserRequestModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test the UserAPIGateway class.
 *
 * This class relies on a running background instance of the back-end.
 * This is not a unit test, but an integration test.
 */
public class UserAPIGatewayTest extends AsyncTestClass {
    UserAPIGateway userAPIGateway;

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        userAPIGateway = new UserAPIGateway(new HTTPRequestManager(context));
    }

    @Test
    public void testCreateUserSuccess() {
        APICreateUserRequestModel request = new APICreateUserRequestModel(
                "bob", "joe", "AndroidTest@test.com",
                "1234password", "27 King's College Cir",
                "Toronto");

        userAPIGateway.createUser(request, new IServerResponseListener() {
            @Override
            public void onRequestSuccess(JSONObject response) {
                try {
                    assertEquals("bob", response.get("firstName"));
                    assertEquals("joe", response.get("lastName"));
                    assertEquals("AndroidTest@test.com", response.get("email"));
                    assertEquals("27 King's College Cir", response.get("homeAddress"));
                    assertEquals("Toronto", response.get("city"));
                    assert response.has("userId");

                } catch (JSONException e) {
                    fail("Incorrect response data received");
                }
            }

            @Override
            public void onRequestError(JSONObject response) {
                fail("Request incorrectly failed");
            }
        });

        awaitForTask(2000);
    }

    @Test
    public void testCreateUserFail() {
        // TODO: The backend does not invalidate data
        //  So we can't test this here yet.
    }
}
