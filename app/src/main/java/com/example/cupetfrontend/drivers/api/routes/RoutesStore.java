package com.example.cupetfrontend.drivers.api.routes;

/**
 * A class used to store various routes to the server.
 */
public class RoutesStore {
    /**
     * The root url for the routes to the server.
     * The android VM runs with a virtual network, so you should set
     * this to http://<your local ip address>:8080.
     */
    public static String ROOT_ROUTE = "http://192.168.0.189:8080";

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
