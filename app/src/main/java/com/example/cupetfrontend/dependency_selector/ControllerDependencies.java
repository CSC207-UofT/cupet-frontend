package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.controllers.UserController;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.use_cases.UserCreator;
import com.example.cupetfrontend.use_cases.api_abstracts.IUserAPIGateway;

public class ControllerDependencies {
    private IUserController userController;

    public ControllerDependencies(APIDependencies apiDependencies, PresenterDependencies presenters) {
        selectUserController(apiDependencies.getUserAPIGateway(), presenters);
    }

    private void selectUserController(IUserAPIGateway userAPIGateway, PresenterDependencies presenters) {
        userController = new UserController(new UserCreator(userAPIGateway, presenters.getCreateUserPresenter()));
    }

    public IUserController getUserController() {
        return userController;
    }
}
