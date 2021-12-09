package com.example.cupetfrontend.controllers.abstracts;

import com.example.cupetfrontend.controllers.cached_data_models.CachedPetData;

/**
 * An interface defining a class responsible for storing the current
 * pet that's signed in
 */
public interface IPetSessionManager {
    /**
     * Get the signed-in pet's id
     *
     * @return The pet's id
     */
    String getPetId();

    /**
     * Set the signed-in pet's id
     */
    void setPetId(String petId);

    /**
     * Get the cached data of the pet that's signed in
     *
     * @return The signed-in pet's cached data
     */
    CachedPetData getCachedPetData();

    /**
     * Set the cached data of the pet that's signed in
     *
     * @param cachedPetData The data to set
     */
    void setCachedPetData(CachedPetData cachedPetData);

    /**
     * Clear all the saved data relating to the pet.
     * (Sign out)
     */
    void clear();
}
