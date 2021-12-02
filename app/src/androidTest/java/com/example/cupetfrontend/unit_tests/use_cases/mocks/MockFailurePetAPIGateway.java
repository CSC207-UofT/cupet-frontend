package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.*;

/**
 * A mock of the PetAPIGateway which always returns a failure response.
 */
public class MockFailurePetAPIGateway extends MockFailureAPIGateway implements IPetAPIGateway {
    @Override
    public void createPet(APICreatePetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void fetchPetProfile(APIFetchPetProfileRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void editPet(APIEditPetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void getPotentialMatches(APIGetPotentialMatchesRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void intendToMatch(APIIntendToMatchRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void rejectMatch(APIRejectMatchRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void getMatches(APIGetMatchesRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void unMatchPet(APIUnMatchPetRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void setPetProfileImage(APISetPetProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void addToPetImageGallery(APIAddToPetImageGalleryRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void removeFromPetImageGallery(APIRemoveFromPetImageGalleryRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }

    @Override
    public void fetchPetProfileImage(APIFetchPetProfileImageRequestModel requestData, IServerResponseListener responseListener) {
        responseListener.onRequestError(createDummyFailResponse());
    }
}
