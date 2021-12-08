package com.example.cupetfrontend.presenters.user;

import com.example.cupetfrontend.presenters.abstracts.IFetchUserAccountPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.IUserAccountViewModel;
import com.example.cupetfrontend.ui.user_account.UserAccountViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;
import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;

public class FetchUserAccountPresenter implements IFetchUserAccountPresenter {
    IUserAccountViewModel userAccountViewModel;

    @Override
    public void setUserAccountViewModel(IUserAccountViewModel userAccountViewModel) {
        this.userAccountViewModel = userAccountViewModel;
    }


    @Override
    public void onFetchUserAccountSuccess(FetchUserAccountSuccessResponseModel response) {
        userAccountViewModel.onUserAccountSuccess(response.getFirstName(),
        response.getLastName(),
        response.getHomeAddress(),
        response.getCity());
    }

    @Override
    public void onFetchUserAccountFailure(DefaultFailureResponseModel response) {

    }

}
