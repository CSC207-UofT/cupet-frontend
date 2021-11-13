package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.controllers.UserController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.EditUserAccountPresenter;
import com.example.cupetfrontend.use_cases.*;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;

public class ControllerDependencies {
    private UserController userController;

    public ControllerDependencies(APIDependencies apiDependencies, PresenterDependencies presenters) {
        selectUserController(apiDependencies.getUserAPIGateway(), presenters);
    }

    private void selectUserController(IUserAPIGateway userAPIGateway, PresenterDependencies presenters) {
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
        userController.setGetPets(new GetPets(userAPIGateway,
                presenters.getGetPetsPresenter()));
    }

    public IUserController getUserController() {
        return userController;
    }
}
