package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IUserAccountViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserAccountOutputBoundary;

public interface IFetchUserAccountPresenter extends FetchUserAccountOutputBoundary {
    void setUserAccountViewModel(IUserAccountViewModel userAccountViewModel);
}
