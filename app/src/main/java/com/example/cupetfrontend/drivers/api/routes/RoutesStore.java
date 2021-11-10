package com.example.cupetfrontend.drivers.api.routes;

/**
 * A class used to store various routes to the server.
 */
public class RoutesStore {
    public static final String ROOT_ROUTE = "http://localhost:3000";

    /**
     * Given a relative route, return its absolute route in context
     * to the root route.
     *
     * For example, if a relative route is "/user/edit" and the root
     * route is "http://localhost:3000", then the absolute route is
     * the full url: "http://localhost:3000/user/edit"
     *
     * @param relativeRoute A relative route
     * @return The absolute route
     */
    public static String toAbsoluteRoute(String relativeRoute) {
        return ROOT_ROUTE + relativeRoute;
    }
}
