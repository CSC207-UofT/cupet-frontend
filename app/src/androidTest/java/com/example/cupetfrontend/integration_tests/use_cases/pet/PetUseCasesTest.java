package com.example.cupetfrontend.integration_tests.use_cases.pet;

import com.example.cupetfrontend.AsyncTaskListener;
import com.example.cupetfrontend.FailedInitializationException;
import com.example.cupetfrontend.drivers.api.PetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.EditPetOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.FetchPetProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.GetPotentialMatchesOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.IntendToMatchOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.pet.PetCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.pet.EditPet;
import com.example.cupetfrontend.use_cases.pet.FetchPetProfile;
import com.example.cupetfrontend.use_cases.pet.GetMatches;
import com.example.cupetfrontend.use_cases.pet.GetPotentialMatches;
import com.example.cupetfrontend.use_cases.pet.IntendToMatch;
import com.example.cupetfrontend.use_cases.pet.PetCreator;
import com.example.cupetfrontend.use_cases.request_models.pet.EditPetRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.GetMatchesRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.GetPotentialMatchesRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.IntendToMatchRequestModel;
import com.example.cupetfrontend.use_cases.request_models.pet.PetCreatorRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.GetPetsRequestModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.EditPetSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.FetchPetProfileSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetMatchesSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.GetPotentialMatchesSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.IntendToMatchSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.PetCreatorSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.GetPetsSuccessResponseModel;
import com.example.cupetfrontend.use_cases.user.GetPets;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test the pet related uses cases:
 *  - getting a list of pets from a user
 *  - editing a pet
 *  - fetching a pet's profile
 *  - getting a list of potential matches for a pet
 *  - getting a list of matches for a pet
 *  - intending to match with another pet
 *  - rejecting a match with another pet
 *
 * NOTE: This is an integration test.
 * The test cases are dependent on each bottom-up, and they
 * should be run in succession.
 *
 * To run these tests, run the entire test class
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetUseCasesTest extends NUsersTestClass {
    private static IPetAPIGateway petAPIGateway;
    private static List<String> petIds;

    @BeforeClass
    public static void setUp() {
        petAPIGateway = new PetAPIGateway(requestManager);
        petIds = new ArrayList<>();
    }

    @Test
    public void test00_setup_createAndLogin(){
        createAndLogin(2, new AsyncTaskListener() {
            @Override
            public void onSuccess() {
                setTaskComplete();
            }

            @Override
            public void onFailure() {
                throw new FailedInitializationException();
            }
        });

        awaitForTask(8000);
    }

    @Test
    public void test0_createPet1(){
        PetCreatorRequestModel request = new PetCreatorRequestModel(
                tokens.get(0),
                "alfred",
                "12",
                "Golden Retriever",
                "this is my dog"
        );

        new PetCreator(petAPIGateway, new PetCreatorOutputBoundary() {
            @Override
            public void onCreatePetSuccess(PetCreatorSuccessResponseModel response) {
                setTaskComplete();

                assertEquals("alfred", response.getName());
                assertEquals("12", response.getAge());
                assertEquals("Golden Retriever", response.getBreed());
                assertEquals("this is my dog", response.getBiography());

                petIds.add(response.getPetId());
            }

            @Override
            public void onCreatePetFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).createPet(request);

        awaitForTask(2000);
    }

    @Test
    public void test0_createPet2(){
        PetCreatorRequestModel request = new PetCreatorRequestModel(
                tokens.get(0),
                "second pet",
                "5",
                "Dog Breed",
                "this is my dog 2"
        );

        new PetCreator(petAPIGateway, new PetCreatorOutputBoundary() {
            @Override
            public void onCreatePetSuccess(PetCreatorSuccessResponseModel response) {
                setTaskComplete();

                assertEquals("second pet", response.getName());
                assertEquals("5", response.getAge());
                assertEquals("Dog Breed", response.getBreed());
                assertEquals("this is my dog 2", response.getBiography());

                petIds.add(response.getPetId());
            }

            @Override
            public void onCreatePetFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).createPet(request);

        awaitForTask(2000);
    }

    @Test
    public void test1_fetchPetProfile(){
        FetchPetProfileRequestModel request = new FetchPetProfileRequestModel(
                tokens.get(0),
                petIds.get(0)
        );

        new FetchPetProfile(petAPIGateway, new FetchPetProfileOutputBoundary() {
            @Override
            public void onFetchPetProfileSuccess(FetchPetProfileSuccessResponseModel response) {
                setTaskComplete();

                assertEquals("alfred", response.getName());
                assertEquals("12", response.getAge());
                assertEquals("Golden Retriever", response.getBreed());
                assertEquals("this is my dog", response.getBiography());
            }

            @Override
            public void onFetchPetProfileFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }

        }).fetchPetProfile(request);

        awaitForTask(2000);
    }

    @Test
    public void test_2_editPetProfile(){
        EditPetRequestModel request = new EditPetRequestModel(
                tokens.get(0),
                petIds.get(0),
                "joe",
                "8",
                "another dog breed",
                "hello world!"
        );

        new EditPet(petAPIGateway, new EditPetOutputBoundary() {
            @Override
            public void onEditPetSuccess(EditPetSuccessResponseModel response) {
                setTaskComplete();

                assertEquals("joe", response.getName());
                assertEquals("8", response.getAge());
                assertEquals("another dog breed", response.getBreed());
                assertEquals("hello world!", response.getBiography());
            }

            @Override
            public void onEditPetFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).editPet(request);

        awaitForTask(2000);
    }

    @Test
    public void test_3_getPets(){
        GetPetsRequestModel request = new GetPetsRequestModel(
                tokens.get(0)
        );

        new GetPets(petAPIGateway, userAPIGateway, new GetPetsOutputBoundary() {
            @Override
            public void onGetPetsSuccess(GetPetsSuccessResponseModel response) {
                setTaskComplete();
                PetData petData = response.getPets().get(0);

                assertEquals(petIds.get(0), petData.getPetId());
                assertEquals("joe", petData.getName());
                assertEquals("8", petData.getAge());
                assertEquals("another dog breed", petData.getBreed());
                assertEquals("hello world!", petData.getBiography());
            }

            @Override
            public void onGetPetsFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).getPets(request);

        awaitForTask(2000);
    }

    @Ignore("Waiting for implementation on backend")
    @Test
    public void test_4_getPotentialMatches(){
        GetPotentialMatchesRequestModel request = new GetPotentialMatchesRequestModel(
                tokens.get(0),
                petIds.get(0)
        );

        new GetPotentialMatches(petAPIGateway, new GetPotentialMatchesOutputBoundary() {
            @Override
            public void onGetPotentialMatchesSuccess(GetPotentialMatchesSuccessResponseModel response) {
                // No need to test the correctness of the matching algorithm here
                // It will be tested on the backend.
                setTaskComplete();
            }

            @Override
            public void onGetPotentialMatchesFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).getPotentialMatches(request);

        awaitForTask(2000);
    }

    @Test
    public void test_5_intendToMatch0(){
        IntendToMatchRequestModel request = new IntendToMatchRequestModel(
                tokens.get(0),
                petIds.get(0),
                petIds.get(1)
        );

        new IntendToMatch(petAPIGateway, new IntendToMatchOutputBoundary() {
            @Override
            public void onIntendToMatchSuccess(IntendToMatchSuccessResponseModel response) {
                setTaskComplete();
            }

            @Override
            public void onIntendToMatchFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).intendToMatch(request);

        awaitForTask(2000);
    }

    @Test
    public void test_5_intendToMatch1(){
        IntendToMatchRequestModel request = new IntendToMatchRequestModel(
                tokens.get(1),
                petIds.get(1),
                petIds.get(0)
        );

        new IntendToMatch(petAPIGateway, new IntendToMatchOutputBoundary() {
            @Override
            public void onIntendToMatchSuccess(IntendToMatchSuccessResponseModel response) {
                setTaskComplete();
            }

            @Override
            public void onIntendToMatchFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");
            }
        }).intendToMatch(request);

        awaitForTask(2000);
    }

    @Test
    public void test_6_getMatches(){
        GetMatchesRequestModel request = new GetMatchesRequestModel(
                tokens.get(0),
                petIds.get(0)
        );

        new GetMatches(petAPIGateway, new GetMatchesOutputBoundary() {
            @Override
            public void onGetMatchesSuccess(GetMatchesSuccessResponseModel response) {
                setTaskComplete();
                // TODO: uncomment test once matching algorithm on back-end is complete
                //  For now, test that we are able to access the endpoint correctly

                PetData petData = response.getMatches().get(0);
//
//                assertEquals(petIds.get(1), petData.getPetId());
//                assertEquals("second pet", petData.getName());
//                assertEquals("5", petData.getAge());
//                assertEquals("Dog Breed", petData.getBreed());
//                assertEquals("this is my dog 2", petData.getBiography());
            }

            @Override
            public void onGetMatchesFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed");

            }
        }).getMatches(request);

        awaitForTask(5000);
    }

    // TODO: Implement test for rejecting match
}
