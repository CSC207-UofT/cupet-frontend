package com.example.cupetfrontend.presenters.view_model_abstracts.nav_context_models;

public class CreatePetContext {
    private final boolean isFromLoginPage;

    public CreatePetContext(boolean isFromLoginPage) {
        this.isFromLoginPage = isFromLoginPage;
    }

    public boolean isFromLoginPage() {
        return isFromLoginPage;
    }
}
