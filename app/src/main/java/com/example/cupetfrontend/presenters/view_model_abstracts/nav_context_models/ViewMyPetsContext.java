package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

public class ViewMyPetsContext {
    private final boolean isFromLoginPage;

    public ViewMyPetsContext(boolean isFromLoginPage) {
        this.isFromLoginPage = isFromLoginPage;
    }

    public boolean isFromLoginPage() {
        return isFromLoginPage;
    }
}
