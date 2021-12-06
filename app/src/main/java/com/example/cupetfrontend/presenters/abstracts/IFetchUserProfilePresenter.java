package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.EditUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.presenters.view_model_abstracts.IFetchUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;

public interface IFetchUserProfilePresenter extends FetchUserProfileOutputBoundary {
    void setFetchUserProfileViewModel(IFetchUserProfileViewModel fetchUserProfileViewModel);
}
