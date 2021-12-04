package com.example.cupetfrontend.controllers.cached_data_models;

public class CachedPetData {
    private final String name;
    private final String profileImgUrl;

    public CachedPetData(String name, String profileImgUrl) {
        this.name = name;
        this.profileImgUrl = profileImgUrl;
    }

    public String getName() {
        return name;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }
}
