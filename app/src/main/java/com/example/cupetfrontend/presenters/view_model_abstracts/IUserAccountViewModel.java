package com.example.cupetfrontend.presenters.view_model_abstracts;

import com.example.cupetfrontend.presenters.data_models.UserAccountData;

public interface IUserAccountViewModel {
    void onUserAccountSuccess(UserAccountData userAccountData);

    void onUserAccountFailure(String message);
}
