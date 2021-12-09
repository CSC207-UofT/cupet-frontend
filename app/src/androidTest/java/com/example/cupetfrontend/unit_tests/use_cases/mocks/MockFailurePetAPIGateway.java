package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerResponseListener;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIAddToPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APICreatePetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIEditPetRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIFetchPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIFetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIGetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIIntendToMatchRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIRejectMatchRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIRemoveFromPetImageGalleryRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APISetPetProfileImageRequestModel;
import com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet.APIUnMatchPetRequestModel;

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
