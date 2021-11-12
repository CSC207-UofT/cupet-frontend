package com.example.cupetfrontend.controllers.abstracts;

/**
 * An interface for a controller which accesses all use cases relating
 * to pets.
 */
public interface IPetController {
    /**
     * Create a new pet
     *
     * @param token The user's session token
     * @param name The name of the pet
     * @param age The age of the pet
     * @param breed The breed of the pet
     * @param biography The pet's biography, as written by the user
     */
    void createPet(String token, String name, String age, String breed, String biography);

    /**
     * Retrieve a pet's profile
     *
     * @param token The user's session token
     * @param petId The pet's id
     */
    void getPetProfile(String token, String petId);
}
