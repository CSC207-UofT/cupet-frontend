package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.*;
import com.example.cupetfrontend.presenters.abstracts.ICreateUserPresenter;

public class PresenterDependencies {
    private ICreateUserPresenter createUserPresenter;
    private EditUserAccountPresenter editUserAccountPresenter;
    private EditUserProfilePresenter editUserProfilePresenter;
    private FetchUserAccountPresenter fetchUserAccountPresenter;
    private FetchUserProfilePresenter fetchUserProfilePresenter;
    private GetPetsPresenter getPetsPresenter;

    public PresenterDependencies() {
        selectCreateUserPresenter();
        selectEditUserProfilePresenter();
        selectFetchUserAccountPresenter();
        selectFetchUserProfilePresenter();
        selectEditUserAccountPresenter();
        selectGetPetsPresenter();
    }

    private void selectCreateUserPresenter () {
        createUserPresenter = new CreateUserPresenter();
    }

    private void selectEditUserAccountPresenter () {
        editUserAccountPresenter = new EditUserAccountPresenter();
    }

    private void selectEditUserProfilePresenter () {
        editUserProfilePresenter = new EditUserProfilePresenter();
    }

    private void selectFetchUserAccountPresenter () {
        fetchUserAccountPresenter = new FetchUserAccountPresenter();
    }

    private void selectFetchUserProfilePresenter () {
        fetchUserProfilePresenter = new FetchUserProfilePresenter();
    }

    private void selectGetPetsPresenter () {
        getPetsPresenter = new GetPetsPresenter();
    }

    public ICreateUserPresenter getCreateUserPresenter() {
        return createUserPresenter;
    }

    public EditUserAccountPresenter getEditUserAccountPresenter() {
        return editUserAccountPresenter;
    }

    public EditUserProfilePresenter getEditUserProfilePresenter() {
        return editUserProfilePresenter;
    }

    public FetchUserAccountPresenter getFetchUserAccountPresenter() {
        return fetchUserAccountPresenter;
    }

    public FetchUserProfilePresenter getFetchUserProfilePresenter() {
        return fetchUserProfilePresenter;
    }

    public GetPetsPresenter getGetPetsPresenter() {
        return getPetsPresenter;
    }
}
