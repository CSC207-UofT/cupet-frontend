package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IPrivateUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.FetchUserProfileOutputBoundary;

public interface IPrivateProfilePresenter extends FetchUserProfileOutputBoundary {
    void setPrivateProfileViewModel(IPrivateUserProfileViewModel privateProfileViewModel);
}
