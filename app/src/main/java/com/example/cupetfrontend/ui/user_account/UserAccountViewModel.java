package com.example.cupetfrontend.ui.user_account;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.cupetfrontend.controllers.SessionManager;
import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.presenters.data_models.UserAccountData;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUserAccountViewModel;

import java.util.Objects;

public class UserAccountViewModel extends ViewModel implements IUserAccountViewModel {
    private final IUserController userController;
    private final MutableLiveData<UserAccountResult> userAccountResult = new MutableLiveData<>();

    public UserAccountViewModel(IUserController userController){
        this.userController = userController;

    }

    public void fetchUserAccount(String token){
        userController.fetchUserAccount(token);
    }

    @Override
    public void onUserAccountSuccess(UserAccountData userAccountData){
        userAccountResult.setValue(new UserAccountResult(userAccountData));
    }

    @Override
    public void onUserAccountFailure(String message) {
        UserAccountResult newFetchUserAccountResult = new UserAccountResult(true, message);
        userAccountResult.setValue(newFetchUserAccountResult);
    }

    public LiveData<UserAccountResult> getUserAccountResult(){
        return this.userAccountResult;
    }
}
