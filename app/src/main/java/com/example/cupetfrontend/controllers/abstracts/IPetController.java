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

    /**
     * Edit a pet's profile
     *
     * @param token The user's session token
     * @param newName The pet's new name
     * @param newAge The pet's new age
     * @param newBreed The pet's new breed
     * @param newBiography The pet's new biography
     */
    void editPet(String token, String newName, String newAge, String newBreed, String newBiography);

    /**
     * Given a pet, return a list of potential matches for the pet.
     *
     * @param token The user's session token
     * @param petId The pet's id
     */
    void getPotentialMatches(String token, String petId);

    /**
     * Given a potential match with another pet, intend to match with another
     * user's pet. A match is only made if the other user intends to match with
     * your pet as well. This is equivalent to swiping right.
     *
     * @param token The user's session token
     * @param myPetId My pet's id
     * @param otherPetId The other user's pet's id
     */
    void intendToMatch(String token, String myPetId, String otherPetId);

    /**
     * Return a list of matches your pet has made.
     *
     * @param token The user's session token
     * @param myPetId The pet's id
     */
    void getMatches(String token, String myPetId);
}
