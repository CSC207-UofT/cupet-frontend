package com.example.cupetfrontend.use_cases;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import com.example.cupetfrontend.AsyncTestClass;
import com.example.cupetfrontend.drivers.api.HTTPRequestManager;
import com.example.cupetfrontend.drivers.api.UserAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import org.junit.Before;

/**
 * A test class providing methods for testing user use cases.
 */
public class UserUseCaseTestClass extends AsyncTestClass {
    IUserAPIGateway userAPIGateway;

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        userAPIGateway = new UserAPIGateway(new HTTPRequestManager(context));
    }
}
