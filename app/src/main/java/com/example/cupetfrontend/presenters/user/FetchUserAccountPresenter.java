package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.ui.user_account.UserAccountViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;

public class FetchUserAccountPresenter implements FetchUserAccountOutputBoundary {
    UserAccountViewModel userAccountViewModel;


    public void setUserAccountViewModel(UserAccountViewModel userAccountViewModel){
        this.userAccountViewModel = userAccountViewModel;
    }

    @Override
    public void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response) {

    }

    @Override
    public void onFetchUserAccountFailure(DefaultFailureResponseModel response) {

    }
}
