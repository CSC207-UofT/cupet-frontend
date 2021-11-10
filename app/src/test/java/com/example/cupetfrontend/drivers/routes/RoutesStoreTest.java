package com.example.cupetfrontend.drivers.routes;

import com.example.cupetfrontend.drivers.api.routes.RoutesStore;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoutesStoreTest {
    /**
     * Test that the RoutesStore.toAbsoluteRoute method correctly
     * converts a relative route to an absolute route, provided
     * that RoutesStore.ROOT_ROUTE is equal to "http://localhost:3000"
     */
    @Test
    public void testCorrectAbsoluteRoute() {
        String relativeRoute = "/pet/create";
        String expected = "http://localhost:3000/pet/create";

        String actual = RoutesStore.toAbsoluteRoute(relativeRoute);
        assertEquals(actual, expected);
    }
}
