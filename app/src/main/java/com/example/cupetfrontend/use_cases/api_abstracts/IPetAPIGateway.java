package com.example.cupetfrontend.use_cases.api_abstracts;

import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.*;

/**
 * Interface with methods for interacting with an external API
 * (server) for actions relating to pets.
 */
public interface IPetAPIGateway {
    /**
     * Create a new pet.
     *
     * @param requestData The data needed to create a new pet.
     * @param responseListener A class with callback methods for when a response is received
     */
    void createPet(APICreatePetRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Fetch a pet's profile
     *
     * @param requestData The data needed to fetch the pet profile
     * @param responseListener A class with callback methods for when a response is received
     */
    void fetchPetProfile(APIFetchPetProfileRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Edit a pet's profile
     *
     * @param requestData The data needed to edit a pet's profile
     * @param responseListener A class with callback methods for when a response is received
     */
    void editPet(APIEditPetRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Given a pet, return a list of potential matches for the pet.
     *
     * @param requestData The data needed to get the list of potential matches
     * @param responseListener A class with callback methods for when a response is received
     */
    void getPotentialMatches(APIGetPotentialMatchesRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Given a potential match with another pet, intend to match with another
     * user's pet. A match is only made if the other user intends to match with
     * your pet as well. This is equivalent to swiping right.
     *
     * @param requestData The data needed to intend to match
     * @param responseListener A class with callback methods for when a response is received
     */
    void intendToMatch(APIIntendToMatchRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Given a potential match with another pet, reject the match.
     *
     * This is equivalent to swiping left.
     *
     * @param requestData The data needed to intend to match
     * @param responseListener A class with callback methods for when a response is received
     */
    void rejectMatch(APIRejectMatchRequestModel requestData, IServerResponseListener responseListener);


    /**
     * Return a list of matches your pet has made.
     *
     * @param requestData The data needed to get a list of matches
     * @param responseListener A class with callback methods for when a response is received
     */
    void getMatches(APIGetMatchesRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Un-match with a pet you've already matched with.
     *
     * @param requestData The data needed to get to un-match
     * @param responseListener A class with callback methods for when a response is received
     */
    void unMatchPet(APIUnMatchPetRequestModel requestData, IServerResponseListener responseListener);

    /**
     * Set a pet's profile image
     *
     * @param requestData The data needed to set the pet's profile image
     * @param responseListener A class with callback methods for when a response is received
     */
    void setPetProfileImage(APISetPetProfileImageRequestModel requestData,
                            IServerResponseListener responseListener);

    /**
     * Add an image to a pet's image gallery
     *
     * @param requestData The data needed to add to the pet's image gallery
     * @param responseListener A class with callback methods for when a response is received
     */
    void addToPetImageGallery(APIAddToPetImageGalleryRequestModel requestData,
                            IServerResponseListener responseListener);

    /**
     * Remove an image from a pet's image gallery
     *
     * @param requestData The data needed to remove from the pet's image gallery
     * @param responseListener A class with callback methods for when a response is received
     */
    void removeFromPetImageGallery(APIRemoveFromPetImageGalleryRequestModel requestData,
                            IServerResponseListener responseListener);

    /**
     * Fetch a pet's profile image
     *
     * @param requestData The data needed to fetch the pet's profile image
     * @param responseListener A class with callback methods for when a response is received
     */
    void fetchPetProfileImage(APIFetchPetProfileImageRequestModel requestData,
                              IServerResponseListener responseListener);
}
