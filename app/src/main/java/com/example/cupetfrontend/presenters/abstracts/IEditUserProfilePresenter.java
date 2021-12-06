package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserProfileViewModel;
import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserProfileOutputBoundary;

public interface IEditUserProfilePresenter extends EditUserProfileOutputBoundary {
    void setEditUserProfileViewModel(IEditUserProfileViewModel editUserProfileViewModel);
}
