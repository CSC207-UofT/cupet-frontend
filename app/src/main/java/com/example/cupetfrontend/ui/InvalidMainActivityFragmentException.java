package com.example.cupetfrontend.ui;

/**
 * An exception thrown when an invalid MainActivity fragment tries to
 * request data from MainActivity.
 *
 * This can be caused by the fragment not properly existing within a MainActivity.
 */
public class InvalidMainActivityFragmentException extends RuntimeException{
    public InvalidMainActivityFragmentException() {
    }
}
