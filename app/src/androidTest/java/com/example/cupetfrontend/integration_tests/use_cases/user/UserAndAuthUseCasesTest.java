package com.example.cupetfrontend.integration_tests.use_cases.user;

import android.content.Context;

import com.example.cupetfrontend.AsyncTestClass;
import com.example.cupetfrontend.drivers.api.AuthAPIGateway;
import com.example.cupetfrontend.drivers.api.HTTPRequestManager;
import com.example.cupetfrontend.drivers.api.UserAPIGateway;
import com.example.cupetfrontend.use_cases.LoginUseCase;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.LoginRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.EditUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.EditUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserAccountRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.UserCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.EditUserProfileSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserProfileSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorSuccessResponseModel;
import com.example.cupetfrontend.use_cases.user.EditUserAccount;
import com.example.cupetfrontend.use_cases.user.EditUserProfile;
import com.example.cupetfrontend.use_cases.user.FetchUserAccount;
import com.example.cupetfrontend.use_cases.user.FetchUserProfile;
import com.example.cupetfrontend.use_cases.user.UserCreator;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test the users and auth related use cases:
 *  - creating a new user
 *  - logging in
 *  - retrieving and editing account
 *  - retrieving and editing profile
 *
 * NOTE: This is an integration test.
 * The test cases are dependent on each bottom-up, and they
 * should be run in succession.
 *
 * To run these tests, run the entire test class.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserAndAuthUseCasesTest extends AsyncTestClass {
    private static IUserAPIGateway userAPIGateway;
    private static IAuthAPIGateway authAPIGateway;
    private static UserCreatorRequestModel newUserRequest;
    private static String token;
    private static String userId;

    @BeforeClass
    public static void setUp(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        IServerRequestManager requestManager = new HTTPRequestManager(context);
        userAPIGateway = new UserAPIGateway(requestManager);
        authAPIGateway = new AuthAPIGateway(requestManager);

        newUserRequest = createNewUniqueUserRequest();
    }

    /**
     * Create a new UserCreator request with a unique email
     *
     * @return a unique UserCreator request
     */
    protected static UserCreatorRequestModel createNewUniqueUserRequest(){
        // Create a unique email in the database using the current time
        String time = ((Long) System.currentTimeMillis()).toString();
        String email = "android_test_" + time + "@android.test";

        return new UserCreatorRequestModel(
                "android_first",
                "android_last",
                email,
                "AndroidPassword",
                "1234 Android St",
                "Android City"
        );
    }

    @Test
    public void test0_createUser(){
        new UserCreator(userAPIGateway, new UserCreatorOutputBoundary() {
            @Override
            public void onCreateUserSuccess(UserCreatorSuccessResponseModel response) {
                setTaskComplete();

                assertEquals(newUserRequest.getFirstName(), response.getFirstName());
                assertEquals(newUserRequest.getLastName(), response.getLastName());
                assertEquals(newUserRequest.getEmail(), response.getEmail());
                assertEquals(newUserRequest.getHomeAddress(), response.getHomeAddress());
                assertEquals(newUserRequest.getCity(), response.getCity());

                userId = response.getUserId();
                System.out.println("Created user for tests. User id: " + userId);
            }

            @Override
            public void onCreateUserFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed " + response.getErrorMessage());
            }
        }).createUser(newUserRequest);

        awaitForTask(2000);
    }

    @Test
    public void test1_login(){
        LoginRequestModel request = new LoginRequestModel(newUserRequest.getEmail(),
                newUserRequest.getPassword());

        new LoginUseCase(authAPIGateway, new LoginOutputBoundary() {
            @Override
            public void onLoginSuccess(LoginSuccessResponseModel response) {
                setTaskComplete();
                token = response.getToken();
            }

            @Override
            public void onLoginFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed " + response.getErrorMessage());
            }
        }).login(request);

        awaitForTask(2000);
    }

    @Test
    public void test2_fetchUserAccount(){
        FetchUserAccountRequestModel request = new FetchUserAccountRequestModel(token);

        new FetchUserAccount(userAPIGateway, new FetchUserAccountOutputBoundary() {

            @Override
            public void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response) {
                setTaskComplete();

                assertEquals(newUserRequest.getFirstName(), response.getFirstName());
                assertEquals(newUserRequest.getLastName(), response.getLastName());
                assertEquals(newUserRequest.getEmail(), response.getEmail());
                assertEquals(newUserRequest.getHomeAddress(), response.getHomeAddress());
                assertEquals(newUserRequest.getCity(), response.getCity());
            }

            @Override
            public void onFetchUserAccountFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed " + response.getErrorMessage());
            }
        }).fetchUserAccount(request);

        awaitForTask(2000);
    }

    @Test
    public void test3_editAccount(){
        EditUserAccountRequestModel request = new EditUserAccountRequestModel(token,
                "android_edited_first", "android_edited_last",
                "android_edited_email@email.com", "1234password",
                "new home", "new city");

        new EditUserAccount(userAPIGateway, new EditUserAccountOutputBoundary() {
            @Override
            public void onEditUserAccountSuccess(EditUserAccountSuccessResponseModel response) {
                setTaskComplete();

                assertEquals("android_edited_first", response.getFirstName());
                assertEquals("android_edited_last", response.getLastName());
                assertEquals("android_edited_email@email.com", response.getEmail());
                assertEquals("new home", response.getHomeAddress());
                assertEquals("new city", response.getCity());
            }

            @Override
            public void onEditUserAccountFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed " + response.getErrorMessage());
            }
        }).editUserAccount(request);

        awaitForTask(2000);
    }

    @Test
    public void test4_editUserProfile(){
        EditUserProfileRequestModel request = new EditUserProfileRequestModel(token,
                "android test biography", "test instagram",
                "test facebook", "123456789");

        new EditUserProfile(userAPIGateway, new EditUserProfileOutputBoundary() {

            @Override
            public void onEditUserProfileSuccess(EditUserProfileSuccessResponseModel response) {
                setTaskComplete();

                assertEquals("android test biography", response.getBiography());
                assertEquals("test instagram", response.getInstagram());
                assertEquals("test facebook", response.getFacebook());
                assertEquals("123456789", response.getPhoneNumber());

            }

            @Override
            public void onEditUserProfileFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed " + response.getErrorMessage());
            }
        }).editUserProfile(request);

        awaitForTask(2000);
    }

    @Test
    public void test5_fetchUserProfile(){
        FetchUserProfileRequestModel request = new FetchUserProfileRequestModel(token, userId);

        new FetchUserProfile(userAPIGateway, new FetchUserProfileOutputBoundary() {
            @Override
            public void onFetchUserProfileSuccess(FetchUserProfileSuccessResponseModel response) {
                setTaskComplete();
                assertEquals("android_edited_first", response.getFirstName());
                assertEquals("android_edited_last", response.getLastName());
                assertEquals("android test biography", response.getBiography());
                assertEquals("test instagram", response.getInstagram());
                assertEquals("test facebook", response.getFacebook());
                assertEquals("123456789", response.getPhoneNumber());
            }

            @Override
            public void onFetchUserProfileFailure(DefaultFailureResponseModel response) {
                fail("Request incorrectly failed " + response.getErrorMessage());
            }
        }).fetchUserProfile(request);

        awaitForTask(2000);
    }
}
