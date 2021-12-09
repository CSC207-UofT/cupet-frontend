package com.example.cupetfrontend.controllers.abstracts;

/**
 * An interface for a controller which accesses all use cases relating
 * to users.
 */
public interface IUserController {
    /**
     * Create a new user.
     * // TODO: too many parameters code smell: combine into request object
     *
     * @param firstName   The first name of the user
     * @param lastName    The last name of the user
     * @param email       The email of the user
     * @param password    The password of the user
     * @param homeAddress The home address of the user
     * @param city        The user's city
     */
    void createUser(String firstName, String lastName, String email, String password, String homeAddress, String city);

    /**
     * Fetch a user's profile.
     *
     * @param token  The login session token
     * @param userId The target user's id.
     */
    void fetchUserProfile(String token, String userId);

    /**
     * Edit a user's profile
     *
     * @param token          The login session token
     * @param newBiography   The user's new biography
     * @param newInstagram   The user's new instagram handle
     * @param newFacebook    The user's new facebook handle
     * @param newPhoneNumber The user's new phone number
     */
    void editUserProfile(String token, String newBiography, String newInstagram,
                         String newFacebook, String newPhoneNumber);

    /**
     * Fetch a user's account information
     *
     * @param token The login session token
     */
    void fetchUserAccount(String token);

    /**
     * Edit a user's account
     *
     * @param token          The login session token
     * @param newFirstName   The user's new first name
     * @param newLastName    The user's new last name
     * @param newEmail       The user's new email
     * @param newPassword    The user's new password
     * @param newHomeAddress The user's new home address
     * @param newCity        The user's new city
     */
    void editUserAccount(String token, String newFirstName, String newLastName,
                         String newEmail, String newPassword, String newHomeAddress, String newCity);

    /**
     * Edit a user's account without changing their password
     *
     * @param token          The login session token
     * @param newFirstName   The user's new first name
     * @param newLastName    The user's new last name
     * @param newEmail       The user's new email
     * @param newHomeAddress The user's new home address
     * @param newCity        The user's new city
     */
    void editUserAccount(String token, String newFirstName, String newLastName,
                         String newEmail, String newHomeAddress, String newCity);

    /**
     * Return a user's list of pets
     *
     * @param token The user's session token
     */
    void getPets(String token);

    /**
     * Set a user's profile image
     *
     * @param token  The user's session token
     * @param imgB64 The image as a base64 string
     */
    void setUserProfileImage(String token, String imgB64);
}
