package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.SetUserProfileImageOutputBoundary;

public interface ISetUserProfileImagePresenter extends SetUserProfileImageOutputBoundary {
    void setViewModel(IEditUserProfileViewModel viewModel);
}
