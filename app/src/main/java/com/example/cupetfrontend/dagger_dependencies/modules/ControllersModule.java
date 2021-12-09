package com.example.cupetfrontend.dagger_dependencies.modules;

import com.example.cupetfrontend.controllers.AuthController;
import com.example.cupetfrontend.controllers.PetController;
import com.example.cupetfrontend.controllers.PetSessionManager;
import com.example.cupetfrontend.controllers.SessionManager;
import com.example.cupetfrontend.controllers.UserController;
import com.example.cupetfrontend.controllers.abstracts.IAuthController;
import com.example.cupetfrontend.controllers.abstracts.IJWTParser;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IPetSessionManager;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.drivers.api.JWTParser;
import com.example.cupetfrontend.use_cases.input_boundaries.LoginInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.EditPetInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.FetchPetProfileInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.GetPotentialMatchesInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.IntendToMatchInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.PetCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.RejectMatchInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.SetPetProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.pet.UnMatchPetInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.EditUserAccountInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.EditUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserAccountInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.FetchUserProfileInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.GetPetsInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.SetUserProfileImageInputBoundary;
import com.example.cupetfrontend.use_cases.input_boundaries.user.UserCreatorInputBoundary;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes={UserUseCasesModule.class, PetUseCasesModule.class, AuthUseCasesModule.class})
public class ControllersModule {
    @Singleton
    @Provides
    public IUserController provideUserController(
            UserCreatorInputBoundary userCreator,
            FetchUserProfileInputBoundary fetchUserProfile,
            EditUserProfileInputBoundary editUserProfile,
            FetchUserAccountInputBoundary fetchUserAccount,
            EditUserAccountInputBoundary editUserAccount,
            GetPetsInputBoundary getPets,
            SetUserProfileImageInputBoundary setUserProfileImage
    ){
        UserController userController = new UserController();

        userController.setUserCreator(userCreator);
        userController.setFetchUserProfile(fetchUserProfile);
        userController.setEditUserProfile(editUserProfile);
        userController.setFetchUserAccount(fetchUserAccount);
        userController.setEditUserAccount(editUserAccount);
        userController.setGetPets(getPets);
        userController.setSetUserProfileImage(setUserProfileImage);

        return userController;
    }

    @Singleton
    @Provides
    public IPetController providePetController(
            PetCreatorInputBoundary petCreator,
            FetchPetProfileInputBoundary fetchPetProfile,
            EditPetInputBoundary editPet,
            GetPotentialMatchesInputBoundary getPotentialMatches,
            IntendToMatchInputBoundary intendToMatch,
            RejectMatchInputBoundary rejectMatch,
            GetMatchesInputBoundary getMatches,
            UnMatchPetInputBoundary unMatchPet,
            SetPetProfileImageInputBoundary setPetProfileImage
    ){
        PetController petController = new PetController();

        petController.setPetCreator(petCreator);
        petController.setFetchPetProfile(fetchPetProfile);
        petController.setEditPet(editPet);
        petController.setGetPotentialMatches(getPotentialMatches);
        petController.setIntendToMatch(intendToMatch);
        petController.setRejectMatch(rejectMatch);
        petController.setGetMatches(getMatches);
        petController.setUnMatchPet(unMatchPet);
        petController.setSetPetProfileImage(setPetProfileImage);

        return petController;
    }

    @Singleton
    @Provides
    public IAuthController provideAuthController(LoginInputBoundary loginUseCase) {
        return new AuthController(loginUseCase);
    }

    @Singleton
    @Provides
    public IJWTParser provideJWTParser() {
        return new JWTParser();
    }

    @Singleton
    @Provides
    public ISessionManager provideSessionManager(IJWTParser jwtParser){
        return new SessionManager(jwtParser);
    }

    @Singleton
    @Provides
    public IPetSessionManager providePetSessionManager(){
        return new PetSessionManager();
    }
}
