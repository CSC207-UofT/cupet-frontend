package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.abstracts.ICreateUserPresenter;
import com.example.cupetfrontend.presenters.user.GetPetsPresenter;
import com.example.cupetfrontend.presenters.user.*;
import com.example.cupetfrontend.use_cases.SetUserProfileImage;

public class UserPresenterDependencies {
    // TODO: replace all with abstract presenter types
    private ICreateUserPresenter createUserPresenter;
    private EditUserAccountPresenter editUserAccountPresenter;
    private EditUserProfilePresenter editUserProfilePresenter;
    private FetchUserAccountPresenter fetchUserAccountPresenter;
    private FetchUserProfilePresenter fetchUserProfilePresenter;
    private GetPetsPresenter getPetsPresenter;
    private SetUserProfileImagePresenter setUserProfileImagePresenter;

    public UserPresenterDependencies() {
        selectCreateUserPresenter();
        selectEditUserProfilePresenter();
        selectFetchUserAccountPresenter();
        selectFetchUserProfilePresenter();
        selectEditUserAccountPresenter();
        selectGetPetsPresenter();
        selectSetUserProfileImagePresenter();
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

    private void selectSetUserProfileImagePresenter () {
        setUserProfileImagePresenter = new SetUserProfileImagePresenter();
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

    public SetUserProfileImagePresenter getSetUserProfileImagePresenter() {
        return setUserProfileImagePresenter;
    }
}
