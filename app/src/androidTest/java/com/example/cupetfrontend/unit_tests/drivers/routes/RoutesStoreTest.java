package com.example.cupetfrontend.unit_tests.drivers.routes;

import com.example.cupetfrontend.drivers.api.routes.RoutesStore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoutesStoreTest {
    /**
     * Test that the RoutesStore.toAbsoluteRoute method correctly
     * converts a relative route to an absolute route.
     */
    @Test
    public void testCorrectAbsoluteRoute() {
        String relativeRoute = "/pet/create";
        RoutesStore.ROOT_ROUTE = "http://example.route";
        String expected = "http://example.route/pet/create";

        String actual = RoutesStore.toAbsoluteRoute(relativeRoute);
        assertEquals(actual, expected);
    }
}
