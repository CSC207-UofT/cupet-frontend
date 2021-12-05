package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.cached_data_models.CachedPetData;

/**
 * A class responsible for storing the session of the pet you've signed in as.
 */
public class PetSessionManager implements IPetSessionManager {
    private String petId;
    private CachedPetData cachedPetData;

    @Override
    public String getPetId() {
        return petId;
    }

    @Override
    public CachedPetData getCachedPetData() {
        return cachedPetData;
    }

    @Override
    public void setCachedPetData(CachedPetData cachedPetData) {
        this.cachedPetData = cachedPetData;
    }

    @Override
    public void clear() {
        petId = null;
        cachedPetData = null;
    }
}
