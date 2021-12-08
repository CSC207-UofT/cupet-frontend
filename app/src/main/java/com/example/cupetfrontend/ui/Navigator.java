package com.example.cupetfrontend.ui;

/**
 * Interface defining a class responsible for navigating
 * to different pages.
 */
public interface Navigator {
    void hideNavigation();

    void showNavigation();

    /**
     * Navigate to navTarget
     * @param navTarget The id of the page to navigate to
     */
    void navigate(int navTarget);

    /**
     * Navigate to navTarget
     *
     * @param navTarget The id of the page to navigate to
     * @param payloadContext The context/data needed to navigate to the new page.
     */
    void navigate(int navTarget, Object payloadContext);
}
