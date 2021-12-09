package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.controllers.AuthController;
import com.example.cupetfrontend.controllers.PetController;
import com.example.cupetfrontend.controllers.UserController;
import com.example.cupetfrontend.controllers.abstracts.IPetController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.use_cases.*;
import com.example.cupetfrontend.use_cases.api_abstracts.IAuthAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IPetAPIGateway;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;
import com.example.cupetfrontend.use_cases.pet.AddToPetImageGallery;
import com.example.cupetfrontend.use_cases.pet.EditPet;
import com.example.cupetfrontend.use_cases.pet.FetchPetProfile;
import com.example.cupetfrontend.use_cases.pet.FetchPetProfileImage;
import com.example.cupetfrontend.use_cases.pet.GetMatches;
import com.example.cupetfrontend.use_cases.pet.GetPotentialMatches;
import com.example.cupetfrontend.use_cases.pet.IntendToMatch;
import com.example.cupetfrontend.use_cases.pet.PetCreator;
import com.example.cupetfrontend.use_cases.pet.RejectMatch;
import com.example.cupetfrontend.use_cases.pet.RemoveFromPetImageGallery;
import com.example.cupetfrontend.use_cases.pet.SetPetProfileImage;
import com.example.cupetfrontend.use_cases.pet.UnMatchPet;
import com.example.cupetfrontend.use_cases.user.EditUserAccount;
import com.example.cupetfrontend.use_cases.user.EditUserProfile;
import com.example.cupetfrontend.use_cases.user.FetchUserAccount;
import com.example.cupetfrontend.use_cases.user.FetchUserProfile;
import com.example.cupetfrontend.use_cases.user.FetchUserProfileImage;
import com.example.cupetfrontend.use_cases.user.GetPets;
import com.example.cupetfrontend.use_cases.user.SetUserProfileImage;
import com.example.cupetfrontend.use_cases.user.UserCreator;

public class ControllerDependencies {
    private UserController userController;
    private PetController petController;
    private AuthController authController;

    public ControllerDependencies(APIDependencies apiDependencies,
                                  UserPresenterDependencies userPresenters,
                                  PetPresenterDependencies petPresenters,
                                  AuthPresenterDependencies authPresenters) {
        selectUserController(apiDependencies.getPetAPIGateway(),
                apiDependencies.getUserAPIGateway(), userPresenters);
        setPetController(apiDependencies.getPetAPIGateway(), petPresenters);
        setAuthController(apiDependencies.getAuthAPIGateway(), authPresenters);
    }

    private void selectUserController(IPetAPIGateway petAPIGateway, IUserAPIGateway userAPIGateway, UserPresenterDependencies presenters) {
        userController = new UserController();

        userController.setUserCreator(new UserCreator(userAPIGateway,
                presenters.getCreateUserPresenter()));
        userController.setEditUserAccount(new EditUserAccount(userAPIGateway,
                presenters.getEditUserAccountPresenter()));
        userController.setFetchUserAccount(new FetchUserAccount(userAPIGateway,
                presenters.getFetchUserAccountPresenter()));
        userController.setFetchUserProfile(new FetchUserProfile(userAPIGateway,
                presenters.getFetchUserProfilePresenter()));
        userController.setEditUserProfile(new EditUserProfile(userAPIGateway,
                presenters.getEditUserProfilePresenter()));
        userController.setGetPets(new GetPets(petAPIGateway, userAPIGateway,
                presenters.getGetPetsPresenter()));
        userController.setSetUserProfileImage(new SetUserProfileImage(
                userAPIGateway, presenters.getSetUserProfileImagePresenter()
        ));
    }

    private void setPetController(IPetAPIGateway petAPIGateway, PetPresenterDependencies petPresenters) {
        petController = new PetController();

        petController.setEditPet(new EditPet(petAPIGateway,
                petPresenters.getEditPetPresenter()));
        petController.setPetCreator(new PetCreator(petAPIGateway,
                petPresenters.getCreatePetPresenter()));
        petController.setFetchPetProfile(new FetchPetProfile(petAPIGateway,
                petPresenters.getFetchPetProfilePresenter()));
        petController.setGetMatches(new GetMatches(petAPIGateway,
                petPresenters.getGetMatchesPresenter()));
        petController.setGetPotentialMatches(new GetPotentialMatches(petAPIGateway,
                petPresenters.getGetPotentialMatchesPresenter()));
        petController.setIntendToMatch(new IntendToMatch(petAPIGateway,
                petPresenters.getIntendToMatchPresenter()));
        petController.setRejectMatch(new RejectMatch(petAPIGateway,
                petPresenters.getRejectMatchPresenter()));
        petController.setUnMatchPet(new UnMatchPet(petAPIGateway,
                petPresenters.getUnMatchPresenter()));
        petController.setSetPetProfileImage(new SetPetProfileImage(petAPIGateway,
                petPresenters.getSetPetProfileImagePresenter()));
    }

    private void setAuthController(IAuthAPIGateway authAPIGateway,
                                   AuthPresenterDependencies authPresenters) {
        authController = new AuthController(new LoginUseCase(authAPIGateway,
                authPresenters.getLoginPresenter()));
    }

    public IUserController getUserController() {
        return userController;
    }

    public PetController getPetController() {
        return petController;
    }

    public AuthController getAuthController() {
        return authController;
    }
}
