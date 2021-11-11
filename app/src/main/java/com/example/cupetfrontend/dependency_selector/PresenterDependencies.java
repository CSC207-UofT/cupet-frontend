package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.CreateUserPresenter;
import com.example.cupetfrontend.presenters.abstracts.ICreateUserPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.UserCreatorOutputBoundary;

public class PresenterDependencies {
    private ICreateUserPresenter createUserPresenter;

    public PresenterDependencies() {
        selectCreateUserPresenter();
    }

    private void selectCreateUserPresenter () {
        createUserPresenter = new CreateUserPresenter();
    }

    public ICreateUserPresenter getCreateUserPresenter() {
        return createUserPresenter;
    }
}
