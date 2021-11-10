package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.CreateUserPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.UserCreatorOutputBoundary;

public class PresenterDependencies {
    private UserCreatorOutputBoundary createUserPresenter;

    public PresenterDependencies() {
        selectCreateUserPresenter();
    }

    private void selectCreateUserPresenter () {
        createUserPresenter = new CreateUserPresenter();
    }

    public UserCreatorOutputBoundary getCreateUserPresenter() {
        return createUserPresenter;
    }
}
