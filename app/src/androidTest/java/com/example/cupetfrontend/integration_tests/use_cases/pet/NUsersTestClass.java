package com.example.cupetfrontend.integration_tests.use_cases.pet;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import com.example.cupetfrontend.AsyncTaskListener;
import com.example.cupetfrontend.AsyncTestClass;
import com.example.cupetfrontend.FailedInitializationException;
import com.example.cupetfrontend.drivers.api.AuthAPIGateway;
import com.example.cupetfrontend.drivers.api.HTTPRequestManager;
import com.example.cupetfrontend.drivers.api.UserAPIGateway;
import com.example.cupetfrontend.use_cases.LoginUseCase;
import com.example.cupetfrontend.use_cases.UserCreator;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IServerRequestManager;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.request_models.LoginRequestModel;
import com.example.cupetfrontend.use_cases.request_models.user.UserCreatorRequestModel;
import com.example.cupetfrontend.use_cases.response_models.LoginFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.UserCreatorSuccessResponseModel;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for testing asynchronous endpoints that need to use
 * some amount of users.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NUsersTestClass extends AsyncTestClass {
    protected static List<UserCreatorRequestModel> newUserRequests;
    protected static List<String> tokens;

    protected static IServerRequestManager requestManager;
    protected static IUserAPIGateway userAPIGateway;
    protected static IAuthAPIGateway authAPIGateway;

    @BeforeClass
    public static void setUpNUsersTestClass(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        requestManager = new HTTPRequestManager(context);
        userAPIGateway = new UserAPIGateway(requestManager);
        authAPIGateway = new AuthAPIGateway(requestManager);

        newUserRequests = new ArrayList<>();
        tokens = new ArrayList<>();
    }

    /**
     * Create a new UserCreator request with a unique email
     *
     * @return a unique UserCreator request
     */
    private UserCreatorRequestModel createNewUniqueUserRequest(){
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

    /**
     * Create and login some number of users.
     *  @param numberOfUsers the number of users to create and login
     * @param listener A listener that listens for the completion of the task
     */
    public void createAndLogin(int numberOfUsers, AsyncTaskListener listener){
        if (numberOfUsers <= 0){
            listener.onSuccess();
        }

        UserCreatorRequestModel request = createNewUniqueUserRequest();
        newUserRequests.add(request);

        new UserCreator(userAPIGateway, new UserCreatorOutputBoundary() {
            @Override
            public void onCreateUserSuccess(UserCreatorSuccessResponseModel response) {
                new LoginUseCase(authAPIGateway, new LoginOutputBoundary() {
                    @Override
                    public void onLoginSuccess(LoginSuccessResponseModel response) {
                        tokens.add(response.getToken());
                        createAndLogin(numberOfUsers - 1, listener);
                    }

                    @Override
                    public void onLoginFailure(LoginFailResponseModel response) {
                        throw new FailedInitializationException();
                    }
                }).login(new LoginRequestModel(request.getEmail(), request.getPassword()));
            }

            @Override
            public void onCreateUserFailure(UserCreatorFailResponseModel response) {
                throw new FailedInitializationException();
            }
        }).createUser(request);
    }
}
