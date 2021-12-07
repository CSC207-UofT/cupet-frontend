package com.example.cupetfrontend.presenters.abstracts;

import com.example.cupetfrontend.use_cases.output_boundaries.user.EditUserAccountOutputBoundary;
import com.example.cupetfrontend.presenters.view_model_abstracts.IEditUserAccountViewModel;
public interface IEditUserAccountPresenter extends EditUserAccountOutputBoundary {
    void setEditUserAccountViewModel(IEditUserAccountViewModel editUserAccountViewModel);
}
