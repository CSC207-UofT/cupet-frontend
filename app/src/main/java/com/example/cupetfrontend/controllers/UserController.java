package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.use_cases.input_boundaries.user.*;
import com.example.cupetfrontend.use_cases.request_models.user.*;

/**
 * A controller which accesses all use cases relating
 * to users.
 */
public class UserController implements IUserController {
    UserCreatorInputBoundary userCreator;
    FetchUserProfileInputBoundary fetchUserProfile;
    EditUserProfileInputBoundary editUserProfile;
    FetchUserAccountInputBoundary fetchUserAccount;
    EditUserAccountInputBoundary editUserAccount;
    GetPetsInputBoundary getPets;

    public void setUserCreator(UserCreatorInputBoundary userCreator) {
        this.userCreator = userCreator;
    }

    public void setFetchUserProfile(FetchUserProfileInputBoundary fetchUserProfile) {
        this.fetchUserProfile = fetchUserProfile;
    }

    public void setEditUserProfile(EditUserProfileInputBoundary editUserProfile) {
        this.editUserProfile = editUserProfile;
    }

    public void setFetchUserAccount(FetchUserAccountInputBoundary fetchUserAccount) {
        this.fetchUserAccount = fetchUserAccount;
    }

    public void setEditUserAccount(EditUserAccountInputBoundary editUserAccount) {
        this.editUserAccount = editUserAccount;
    }

    public void setGetPets(GetPetsInputBoundary getPets) {
        this.getPets = getPets;
    }

    @Override
    public void createUser(String firstName, String lastName, String email, String password, String homeAddress, String city){
        UserCreatorRequestModel request = new UserCreatorRequestModel(
                firstName, lastName, email, password, homeAddress, city);

        userCreator.createUser(request);
    }

    @Override
    public void fetchUserProfile(String token, String userId) {
        FetchUserProfileRequestModel request = new FetchUserProfileRequestModel(
                token, userId);

        fetchUserProfile.fetchUserProfile(request);
    }

    @Override
    public void editUserProfile(String token, String newBiography) {
        EditUserProfileRequestModel request = new EditUserProfileRequestModel(
                token, newBiography);

        editUserProfile.editUserProfile(request);
    }

    @Override
    public void fetchUserAccount(String token) {
        FetchUserAccountRequestModel request = new FetchUserAccountRequestModel(token);

        fetchUserAccount.fetchUserAccount(request);
    }

    @Override
    public void getPets(String token) {
        GetPetsRequestModel request = new GetPetsRequestModel(token);

        getPets.getPets(request);
    }

    @Override
    public void editUserAccount(String token, String newFirstName, String newLastName, String newEmail,
                                String newPassword, String newHomeAddress, String newCity) {
        EditUserAccountRequestModel request = new EditUserAccountRequestModel(
                token, newFirstName, newLastName, newEmail, newPassword, newHomeAddress, newCity
        );

        editUserAccount.editUserAccount(request);
    }
}
