package com.example.cupetfrontend.use_cases;

import com.example.cupetfrontend.use_cases.output_boundaries.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.UserCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.UserCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.UserCreatorSuccessResponseModel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A test class for testing the create-user use case.
 *
 * Note: the tests here rely on an instance of the back-end being run
 * in the background. These are integration tests, not unit tests.
 */
public class UserCreatorTest extends UserUseCaseTestClass{
    @Test
    public void testCreateUserSuccess() {
        UserCreatorRequestModel request = new UserCreatorRequestModel(
                "bob", "joe", "bob@email.com",
                "1234password", "1234 home st");

        UserCreatorSuccessResponseModel expected = new UserCreatorSuccessResponseModel(
                "bob", "joe", "bob@email.com", "1234 home st", "any"
        );

        UserCreator userCreator = new UserCreator(userAPIGateway, new UserCreatorOutputBoundary() {
            @Override
            public void onCreateUserSuccess(UserCreatorSuccessResponseModel response) {
                setTaskComplete();
                assertEquals(response.getFirstName(), expected.getFirstName());
                assertEquals(response.getLastName(), expected.getLastName());
                assertEquals(response.getEmail(), expected.getEmail());
                assertEquals(response.getHomeAddress(), expected.getHomeAddress());
                assertNotNull(response.getUserId());
            }

            @Override
            public void onCreateUserFailure(UserCreatorFailResponseModel response) {
                fail("Request incorrectly failed");
            }
        });

        userCreator.createUser(request);

        awaitForTask(2000);
    }

    @Test
    public void testCreateUserFailure() {
        // TODO: Uncomment later
        //  The backend does not respond with errors for invalid data, so we can't test this yet
//        UserCreatorRequestModel request = new UserCreatorRequestModel(
//                "bob", "joe", "bob@email.com",
//                "1234password", "1234 home st");
//
//        UserCreator userCreator = new UserCreator(userAPIGateway, new UserCreatorOutputBoundary() {
//            @Override
//            public void onCreateUserSuccess(UserCreatorSuccessResponseModel response) {
//                fail("Request incorrectly succeeded");
//            }
//
//            @Override
//            public void onCreateUserFailure(UserCreatorFailResponseModel response) {
//                setTaskComplete();
//            }
//        });
//
//        userCreator.createUser(request);
//
//        awaitForTask(2000);
    }

}