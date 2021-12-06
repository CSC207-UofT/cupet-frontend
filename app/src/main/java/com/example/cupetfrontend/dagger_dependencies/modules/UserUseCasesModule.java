package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.input_boundaries.user.EditUserAccountInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.EditUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserAccountInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.GetPetsInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.SetUserProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.UserCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.GetPetsOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.SetUserProfileImageOutputBoundary;
import com.example.cupetfrontend.use_cases.output_boundaries.user.UserCreatorOutputBoundary;
import com.example.cupetfrontend.use_cases.user.EditUserAccount;
import com.example.cupetfrontend.use_cases.user.EditUserProfile;
import com.example.cupetfrontend.use_cases.user.FetchUserAccount;
import com.example.cupetfrontend.use_cases.user.FetchUserProfile;
import com.example.cupetfrontend.use_cases.user.FetchUserProfileImage;
import com.example.cupetfrontend.use_cases.user.GetPets;
import com.example.cupetfrontend.use_cases.user.SetUserProfileImage;
import com.example.cupetfrontend.use_cases.user.UserCreator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes={APIGatewaysModule.class, UserOutputBoundariesModule.class})
public class UserUseCasesModule {
    @Singleton
    @Provides
    public EditUserAccountInputBoundary provideEditUserAccount(
            IUserAPIGateway userAPIGateway, EditUserAccountOutputBoundary outputBoundary){
        return new EditUserAccount(userAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public EditUserProfileInputBoundary provideEditUserProfile(
            IUserAPIGateway userAPIGateway, EditUserProfileOutputBoundary outputBoundary){
        return new EditUserProfile(userAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public FetchUserAccountInputBoundary provideFetchUserAccount(
            IUserAPIGateway userAPIGateway, FetchUserAccountOutputBoundary outputBoundary){
        return new FetchUserAccount(userAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public FetchUserProfileInputBoundary provideFetchUserProfile(
            IUserAPIGateway userAPIGateway, FetchUserProfileOutputBoundary outputBoundary){
        return new FetchUserProfile(userAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public FetchUserProfileImageInputBoundary provideFetchUserProfileImage(
            IUserAPIGateway userAPIGateway, FetchUserProfileImageOutputBoundary outputBoundary){
        return new FetchUserProfileImage(userAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public GetPetsInputBoundary provideGetPets(
            IPetAPIGateway petAPIGateway, IUserAPIGateway userAPIGateway,
            GetPetsOutputBoundary outputBoundary){
        return new GetPets(petAPIGateway, userAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public SetUserProfileImageInputBoundary provideSetUserProfileImage(
            IUserAPIGateway userAPIGateway, SetUserProfileImageOutputBoundary outputBoundary){
        return new SetUserProfileImage(userAPIGateway, outputBoundary);
    }

    @Singleton
    @Provides
    public UserCreatorInputBoundary provideUserCreator(
            IUserAPIGateway userAPIGateway, UserCreatorOutputBoundary outputBoundary){
        return new UserCreator(userAPIGateway, outputBoundary);
    }
}
